#!/usr/bin/python

import argparse
import os 
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
                "11": "desktop-wallpaper-calendars-november-",
                "12": "christmas-wallpaper-calendars-"}


def get_wallpapers(year, month, size):
    page_month = str(int(month) - 1)
    page_year = year
    if month == "01":
        page_month = "12"
        page_year = str(int(year) - 1)

    url = "https://www.smashingmagazine.com/{page_year}/{page_month}/{page_name}{year}/".format(page_year=page_year, page_month=page_month, page_name=PAGE_NAMES[month], year=year)
    
    r = do_get(url)
    if not r:
        return

    soup = BeautifulSoup(r.text, "html.parser")

    wallpaper_urls = [w.attrs["href"] for w in soup.find_all("a", text=size)]
    print("Found {} wallpapers".format(len(wallpaper_urls)))

    saved_wallpapers = 0
    for number, wallpaper_url in enumerate(wallpaper_urls):
        if get_picture(wallpaper_url):
            saved_wallpapers += 1


    print("Saved {} wallpapers".format(saved_wallpapers))

def get_picture(url):
    result = False

    wallpaper_response = do_get(url, stream=True)
    if wallpaper_response:
        p = os.path.abspath(url[url.rfind("/")+1:])
        # print("Saving to {}".format(p))
        with open(p, "wb") as f:
            for chunk in wallpaper_response.iter_content():
                f.write(chunk)
            result = True
    return result

def do_get(url, stream=False):
    # print("GET {}".format(url))
    response = requests.get(url, stream=stream) 
    try:
        response.raise_for_status()
    except requests.exceptions.HTTPError as e:
        print(str(e))
        return nil
    return response

def main(argv):
    dimensions = args.dimensions.replace("x", "×")
    get_wallpapers(args.year, args.month, dimensions)

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("month", choices=["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"], default = "11", help="month in MM, e.g. 01, 12")
    parser.add_argument("year", default = "2017", help="year in YYYY, e.g. 2017")
    parser.add_argument("dimensions", default = "320x480", help="dimensions of wallpapers, e.g. 320x480")
    args = parser.parse_args()
    print("month {}, year {}, size {}".format(args.month, args.year, args.dimensions))
    main(args)