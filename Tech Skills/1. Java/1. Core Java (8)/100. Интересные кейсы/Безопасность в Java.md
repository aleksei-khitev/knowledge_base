# Безопасность в Java
## Проерка подписанности jar-файла
```sh
jarsigner -verify someName.jar
```
```sh
jarsigner.exe -verify -verbose .\deployer.jar
```

## Просмотр данных сертификата
```sh
keytool -list -v -keystore someCodeSignStore.jks
```
```sh
keytool -list -v -keystore keystore
```