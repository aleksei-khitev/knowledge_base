# Дебаг JNLP
## Подготовить jnlp
* Скачать файл jnlp
* Вставить `-ea -server` в раздел `<j2se version="1.8+" java-vm-args="[сюда]" />`

## Сделать скрипт
```sh
#!/bin/sh
export JAVAWS_TRACE_NATIVE=1
export JAVAWS_VM_ARGS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8989,server=y,suspend=n"
javaws -wait ./your.jnlp
```