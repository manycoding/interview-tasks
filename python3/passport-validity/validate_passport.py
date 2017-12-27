"""
Нужно написать функцию на Python проверки актуальности паспорта.
Паспорт выдается в 14 лет и должен быть заменен в 20 и 45 лет,
 на замену паспорта дается 1 месяц.
Функция должна принимать две даты - дата рождения и дату выдачи паспорта,
возвращать должна True если паспорт действителен, False - есть нет.

Python3
Замена 1 месяц значит что текущий паспорт действителен до возраста замены
плюс 1 месяц, не включительно

"""

from datetime import datetime
from dateutil.rrule import rrule, MONTHLY


def check_passport(birth_date, issue_date):
    """
    Check passport validity on the current date.
    The function takes two string arguments in dd.mm.yyyy format
    """
    birth_d = datetime.date(datetime.strptime(birth_date, "%d.%m.%Y"))
    issue_d = datetime.date(datetime.strptime(issue_date, "%d.%m.%Y"))
    current_date = datetime.now().date()

    # age = abs((current_date.year - birth_d.year))
    # age_m = abs(current_date.year - birth_d.year) * 12 +
    #             abs(current_date.month - birth_d.month)
    # Current age in whole months
    age_m = len([dt for dt in rrule(MONTHLY, dtstart=birth_d, until=current_date)]) - 1

    # True if issued after 14 and age is between 14 and 20 plus 1 month
    if age_m >= 14 * 12 and age_m < 20 * 12 + 1 and issue_d >= birth_d.replace(year=birth_d.year + 14):
        return True

    # True if issued after 20 and age is between 20 + 1 month
    # and 45 + 1 month
    if age_m >= 20 * 12 + 1 and age_m < 45 * 12 + 1 and issue_d > birth_d.replace(year=birth_d.year + 20):
        return True

    # True if issued after 45 and age is after 45 + 1 month
    if age_m >= 45 * 12 + 1 and issue_d > birth_d.replace(year=birth_d.year + 45):
        return True

    return False
