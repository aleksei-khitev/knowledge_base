"""Программа для расчета процента от общего количества"""


def calculate(for_calculation_count, overall_count):
    """Выполняет расчет. Первый аргемант - число для которого считаем процент. Второй - общее количество"""
    print('Количество для расчета процентов: %s' % for_calculation_count)
    print('Общее количество: %s' % overall_count)
    print('percents = for_calculation_count * 100 / overall_count')
    percents = float(for_calculation_count) * 100 / float(overall_count)
    print(percents)
