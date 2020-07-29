#!/usr/bin/env python3
import sys

print('----------\n%s\n----------' % ('Расчет процентов'))
args = sys.argv
for_calculation_count = args[1]
overall_count = args[2]
print('Путь к выполняемому файлу: %s' % args[0])
print('Количество для расчета процентов: %s' % for_calculation_count)
print('Общее количество: %s' % overall_count)
print('percents = for_calculation_count * 100 / overall_count')
percents = float(for_calculation_count) * 100 / float(overall_count)
print(percents)