# Создание jar
## Утилита для упаковки в Jar
```sh
jar [параметры] место_назначения [манифест] список_файлов
```
Формат ZIP также применяется в файлах JAR<br/>
Файл JAR содержит набор сжатых файлов с манифестом (manifest), который их описывает.<br/>
Манифест можно сделать самому, иначе он будет создан приложеним jar.<br/>
_Эккель Б. Философия Java. 4-е полное изд. Стр. 784_

## Допустимы следующие параметры
| | |
| --- | --- |
| `c` | Создает новый или пустой архив |
| `t` | Распечатывает содержимое архива |
| `x` | Извлекает все файлы |
| `x файл` | Извлекает все указанные файлы |
| `f` | Признак задания имени файла<br/>Если не использовать этот параметр, jar решит, что входные данные поступают из стандартного ввода, или при создании файла - что выходные данные направляются в стандартный поток вывода |
| `m` | Указывает, что в первом аргументе передается имя файла спользовательским манифестом |
| `v` | Выводит подробную информацию о функциональности jar |
| `O` | Просто сохраняет файлы без сжатия<br/>(для создания файлов JAR, которые можно указать в переменной оркужения CLASSPATH) |
| `M` | Не включать манифест |

_Эккель Б. Философия Java. 4-е полное изд. Стр. 785_