# Синхронизация
## rsync
В мире UNIX-подобных систем для решения задачи синхронизации используется команда `rsync`
Эта программа синхронизирует локальные и удаленные каталоги используя протокол `rsync remote-update`, который позволяет `rsync` быстро обнаруживать различия между двумя каталогами и копировать минимальный объем данных, необходимый для синхронизации.
Как итог, `rsync` - быстрый и экономичный по сравнению с другими программами копирования.
Имеет синтаксис `rsync параметры источник приемник`
Тут роль источника и приемника могут играть:
- локальный файл или каталог
- удаленный файл или каталог в формате `user@host:path`
- удаленный сервер `rsync` , определяемый идентификатором URI `rsync://user@host:port/path`
При этом, или источник или приемник должен **находится локально в системе**.
Ключ `-v` выводит отладочную информацию
Ключ `-a` обеспечивает рекурсивный обход и сохранение атрибутов файлов
```sh
$ ls os_backup
ls: невозможно получить доступ к 'os_backup': Нет такого файла или каталога
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС ~/os_backup
sending incremental file list
created directory /home/akhitev/os_backup
Занятия по ОС/
Занятия по ОС/.~lock.linux_3.pptx#
Занятия по ОС/linux_1.pptx
Занятия по ОС/linux_2.pptx
Занятия по ОС/linux_3.pptx
Занятия по ОС/Занятия по Операционным системам.md

sent 2.788.553 bytes  received 161 bytes  5.577.428,00 bytes/sec
total size is 2.787.384  speedup is 1,00
$ ls os_backup
'Занятия по ОС'
$
```

В конце выводится статистика
```sh
sent 2.788.553 bytes  received 161 bytes  5.577.428,00 bytes/sec
total size is 2.787.384  speedup is 1,00
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 276-277*
### Обновление по дельте
Если снова запустить - ничего не произойдет, так как ничего не изменилось.
```sh
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС ~/os_backup
sending incremental file list

sent 283 bytes  received 17 bytes  600,00 bytes/sec
total size is 2.787.446  speedup is 9.291,49
```
Но если обновить файл внутри каталога, он синхронизируется
```sh
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС ~/os_backup
sending incremental file list
Занятия по ОС/Занятия по Операционным системам.md

sent 1.517 bytes  received 36 bytes  3.106,00 bytes/sec
total size is 2.787.446  speedup is 1.794,88
$
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 277*
### Синхронизация не самого каталога, а только содержимого
Если источник указать просто именем, то скопируется папка, а если добавить в конце `/`, то скопируется содержимоей папки
```sh
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС ~/os_backup
sending incremental file list
created directory /home/akhitev/os_backup
Занятия по ОС/
Занятия по ОС/.~lock.linux_3.pptx#
Занятия по ОС/linux_1.pptx
Занятия по ОС/linux_2.pptx
Занятия по ОС/linux_3.pptx
Занятия по ОС/Занятия по Операционным системам.md

sent 2.788.553 bytes  received 161 bytes  5.577.428,00 bytes/sec
total size is 2.787.384  speedup is 1,00
$ ls os_backup
'Занятия по ОС'
$
```
Со символом `/` в конце источника
```sh
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ ~/os_backup2
sending incremental file list
created directory /home/akhitev/os_backup2
./
.~lock.linux_3.pptx#
linux_1.pptx
linux_2.pptx
linux_3.pptx
Занятия по Операционным системам.md

sent 2.788.579 bytes  received 161 bytes  5.577.480,00 bytes/sec
total size is 2.787.446  speedup is 1,00
$ ls os_backup2
 linux_1.pptx   linux_2.pptx   linux_3.pptx  'Занятия по Операционным системам.md'
$
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 277*
### Удаление файлов, которых больше нет в источнике, но есть в приемнике
```sh
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ ~/os_backup2
sending incremental file list
./
123

sent 315 bytes  received 38 bytes  706,00 bytes/sec
total size is 2.787.450  speedup is 7.896,46
$ ls os_backup2
 123   linux_1.pptx   linux_2.pptx   linux_3.pptx  'Занятия по Операционным системам.md'
$ rm /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/123
$ rsync -av /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ ~/os_backup2
sending incremental file list
./

sent 253 bytes  received 19 bytes  544,00 bytes/sec
total size is 2.787.446  speedup is 10.247,96
$ ls os_backup2
 123   linux_1.pptx   linux_2.pptx   linux_3.pptx  'Занятия по Операционным системам.md'
$
```
Просто так лишний файл не удалился. Чтобы удаленные в источнике файлы удалялись и в приемнике нужно добавить параметр `--delete`
```sh
$ rsync -av --delete /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ ~/os_backup2
sending incremental file list
deleting 123

sent 246 bytes  received 19 bytes  530,00 bytes/sec
total size is 2.787.446  speedup is 10.518,66
$ ls os_backup2
 linux_1.pptx   linux_2.pptx   linux_3.pptx  'Занятия по Операционным системам.md'
$
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 278-279*
### Указание нескольких источников за раз
Можно указать несколько источников за раз и тогда они будут синхронизированы с приемником, указанным в конце
```sh
$ rsync -av --delete /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/knowledge_base/1.\ Tech\ Skills/5.\ Администрирование,\ DevOps/1.\ Linux/13.\ Процессы ~/os_backup2
sending incremental file list
13. Процессы/
13. Процессы/13. Процессы.md

sent 19.560 bytes  received 39 bytes  39.198,00 bytes/sec
total size is 2.806.614  speedup is 143,20
$ ls os_backup2
'13. Процессы'   linux_1.pptx   linux_2.pptx   linux_3.pptx  'Занятия по Операционным системам.md'
$
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 278-279*
### Синхронизация по сети
Чтоб синхронизироваться через сеть, нужно еще добавить параметр, указывающий, как осуществляется связь. К примеру, `--rsh=ssh`
```sh
$ rsync -av --delete --rsh=ssh /home/akhitev/Dropbox/AKhitev_Obsidian/AKhitev/Мои\ разработка/Занятия\ по\ ОС/ pi@192.168.1.34:/home/pi/os_backup2
pi@192.168.1.34's password: 
sending incremental file list
created directory /home/pi/os_backup2
./
.~lock.linux_3.pptx#
linux_1.pptx
linux_2.pptx
linux_3.pptx
Занятия по Операционным системам.md

sent 2.788.585 bytes  received 156 bytes  429.037,08 bytes/sec
total size is 2.787.446  speedup is 1,00
```
И на удаленной машине
```sh
$ ssh pi@192.168.1.34
pi@192.168.1.34's password: 
Linux khitev-raspberrypi 4.19.66-v7+ #1253 SMP Thu Aug 15 11:49:46 BST 2019 armv7l

The programs included with the Debian GNU/Linux system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Debian GNU/Linux comes with ABSOLUTELY NO WARRANTY, to the extent
permitted by applicable law.
Last login: Wed Nov 20 21:01:25 2024 from 192.168.1.120
pi@khitev-raspberrypi:~ $ pwd
/home/pi
pi@khitev-raspberrypi:~ $ ls
get-docker.sh  log  media-controller-0.1.0.war  os_backup2  plexmediaserver-ros6-binaries-annapurna_1.12.0.4829-6de959918_armel.deb  trial_lesson.war
pi@khitev-raspberrypi:~ $ 
```
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 279*
## Работа в режиме демона
`rsync` может работать в качестве демона, принимающего запросы на синхронизация
*Командная строка Linux. Полное руководство. 2-е межд. изд., стр. 279*