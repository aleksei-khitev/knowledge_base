#!/usr/bin/env python3
"""Программа для расчета процента от общего количества"""
import sys


def calculate(for_calculation_count, overall_count):
    """Выполняет расчет. Первый аргемант - число для которого считаем процент. Второй - общее количество"""
    print('Количество для расчета процентов: %s' % for_calculation_count)
    print('Общее количество: %s' % overall_count)
    print('percents = for_calculation_count * 100 / overall_count')
    percents = float(for_calculation_count) * 100 / float(overall_count)
    print(percents)


print('----------\n%s\n----------' % 'Расчет процентов')
args = sys.argv
print('Путь к выполняемому файлу: %s' % args[0])
calculate(args[1], args[2])
