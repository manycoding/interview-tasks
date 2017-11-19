import wallpaper_downloader

def test_get_wallpapers():
    found, saved = wallpaper_downloader.get_wallpapers(
        "2017", "11", "320×480", verbosity=0, test=True)
    assert found == saved == 36, "Found was {} and saved was {}, should be 36".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2017", "01", "1920×1440", verbosity=0, test=True)
    assert found == saved == 30, "Found was {} and saved was {}, should be 30".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2014", "06", "320×480", verbosity=0, test=True)
    assert found == saved == 21, "Found was {} and saved was {}, should be 21".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2027", "01", "1920×1440", verbosity=0, test=True)
    assert found == saved == 0, "Found was {} and saved was {}, should be 0".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2015", "12", "4000×1440", verbosity=0, test=True)
    assert found == saved == 0, "Found was {} and saved was {}, should be 0".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2014", "12", "320×480", verbosity=0, test=True)
    assert found == saved == 3, "Found was {} and saved was {}, should be 3".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2014", "11", "320×480", verbosity=0, test=True)
    assert found == saved == 0, "Found was {} and saved was {}, should be 0".format(
        found, saved)

    found, saved = wallpaper_downloader.get_wallpapers(
        "2015", "01", "1920×1440", verbosity=0, test=True)
    assert found == saved == 2, "Found was {} and saved was {}, should be 2".format(
        found, saved)
