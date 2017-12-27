import validate_passport


def test_check_passport():
    # 14+
    assert validate_passport.check_passport("27.12.2003", "27.12.2017")
    assert validate_passport.check_passport("28.11.2003", "27.12.2017")
    assert not validate_passport.check_passport("27.12.2004", "27.12.2013")

    assert validate_passport.check_passport("27.01.2003", "28.01.2017")

    # 20+
    assert validate_passport.check_passport("27.11.1997", "10.12.2017")
    assert validate_passport.check_passport("28.11.1997", "20.12.2011")
    assert not validate_passport.check_passport("27.11.1997", "26.12.2011")

    assert validate_passport.check_passport("27.05.1997", "10.06.2017")

    # 45+
    assert validate_passport.check_passport("27.12.1972", "27.01.2017")
    assert validate_passport.check_passport("28.11.1972", "10.12.1992")
    assert not validate_passport.check_passport("27.11.1972", "26.12.1992")

    assert validate_passport.check_passport("27.10.1972", "26.11.2017")
