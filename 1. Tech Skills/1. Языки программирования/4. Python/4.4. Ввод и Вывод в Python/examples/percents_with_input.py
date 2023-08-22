#!/usr/bin/env python3
print('----------\n%s\n----------' % ('Расчет процентов'))
for_calculation_count = input('Введите Количество для расчета процентов:')
overall_count = input('Введите Общее количество:')
print('percents = for_calculation_count * 100 / overall_count')
percents = float(for_calculation_count) * 100 / float(overall_count)
print(percents)