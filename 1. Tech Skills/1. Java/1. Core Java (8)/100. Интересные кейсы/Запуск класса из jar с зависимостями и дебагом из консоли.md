# Запуск класса из jar с зависимостями и дебагом из консоли
```sh
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8989 -cp /some_path/some_jar.jar:/some_path_lib_dir/* some.package.SOmeClass
```