#!/usr/bin/python3

import argparse
import os
import re
import requests
from bs4 import BeautifulSoup

PAGE_NAMES = {"01": "desktop-wallpaper-calendars-january-",
                "02": "desktop-wallpaper-calendars-february-",
                "03": "desktop-wallpaper-calendars-march-",
                "04": "desktop-wallpaper-calendars-april-",
                "05": "desktop-wallpaper-calendars-may-",
                "06": "desktop-wallpaper-calendars-june-",
                "07": "desktop-wallpaper-calendars-july-",
                "08": "desktop-wallpaper-calendars-august-",
                "09": "desktop-wallpaper-calendars-september-",
                "10": "desktop-wallpaper-calendars-october-",
                "11": "desktop-wallpaper-calendars-november-"}

def get_wallpapers(year, month, size, verbosity, test=False):
    page_month = str(int(month) - 1)
    page_year = year
    if month == "01":
        page_month = "12"
        page_year = str(int(year) - 1)

    if month == "12":
        url = "https://www.smashingmagazine.com/2016/11/christmas-wallpaper-calendars-2016/"
    else:
        url = "https://www.smashingmagazine.com/{page_year}/{page_month}/{page_name}{year}/".format(page_year=page_year, page_month=page_month, page_name=PAGE_NAMES[month], year=year)

    log(message="GET {}".format(url), verbosity=verbosity, message_verbosity=1)
    r = do_get(url)
    if not r:
        return 0, 0

    wallpaper_urls = get_wallpaper_urls(r.text, year, size, verbosity)
    print("Saving images...")
    saved_wallpapers = 0
    for number, wallpaper_url in enumerate(wallpaper_urls):
        if get_picture(wallpaper_url, verbosity, test):
            saved_wallpapers += 1

    return len(wallpaper_urls), saved_wallpapers

def get_wallpaper_urls(page_source, year, size, verbosity):
    year = year[2:]
    soup = BeautifulSoup(page_source, "html.parser")
    log(soup.prettify(), verbosity, 3)
    size = size.replace("x", "×")
    return [w.attrs["href"] for w in soup.find_all("a", text=size, href=re.compile("{}/".format(year)))]

def get_picture(url, verbosity, test=False):
    result = False

    log(message="GET {}".format(url), verbosity=verbosity, message_verbosity=2)
    wallpaper_response = do_get(url, stream=True)
    if wallpaper_response:
        p = os.path.abspath(url[url.rfind("/")+1:])
        if not test:
            with open(p, "wb") as f:
                for chunk in wallpaper_response.iter_content():
                    f.write(chunk)
        result = True
        log(p, verbosity=verbosity)
    return result

def do_get(url, stream=False):
    response = requests.get(url, stream=stream) 
    try:
        response.raise_for_status()
    except requests.exceptions.HTTPError as e:
        print(str(e))
        return None
    return response

def log(message, verbosity, message_verbosity=1):
    if verbosity >= message_verbosity:
        print(message)

def main(argv):
    found, saved = get_wallpapers(year=args.year, month=args.month, size=args.dimensions, verbosity=args.verbosity, test=args.test)
    print("Found {}, saved {} wallpapers".format(found, saved))

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("month", choices=["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"], default="11", help="month in MM, e.g. 01, 12")
    parser.add_argument("year", default="2017", help="year in YYYY, e.g. 2017")
    parser.add_argument("dimensions", default= "320x480", help="dimensions of wallpapers, e.g. 320x480")
    parser.add_argument("-v", "--verbosity", action="count", default=0, help="increase output verbosity")
    parser.add_argument("-t", "--test", action="store_true", help="write output without saving files")
    args = parser.parse_args()
    print("month {}, year {}, size {}".format(args.month, args.year, args.dimensions))
    main(args)