# API для Интернет-банка
## О проекте
Проект выполнен с целью обучения.<br/>
Для запуска приложения нужны инструменты приведенные ниже или их функциональные аналоги:
* intellij idea
* jdk1.8
* Maven
* Tomcat 9
* PostgreSQL
* Postman
* DBeaver

## Инициализация базы данных
Для работы приложения нужно указать конфигурационные настройки для подключения к базе данных.<br/>
В MyConfig.java бин DataSource предназначен для подключения к серверу PostgreSQL.<br/>
Настройки для подключения храниться в файле dbcfg.json который храниться в дериктории src/main/resources<br/>

Нужно подправить поля в файле dbcfg.json, если ваши настройки отличаються:
```json
[
  {
    "setDriverClass": "org.postgresql.Driver",
    "setJdbcUrl": "jdbc:postgresql://localhost:5432/postgres",
    "setUser": "admin",
    "setPassword": "admin"
  }
]
```

Для инициализации таблицы в безе данных можно использовать скрипт data.sql, который хрониться в дериктории src/main/resources

## Пример запросов
### Запрос баланса:
GET http://localhost:8080/spring_course_rest/api/account/1 <br/>
где /1 - id account -а. Да пока так, все открыто, для тестов.
### Снятие деньги со счета: 
POST http://localhost:8080/spring_course_rest/api/account/take <br/>
В тело включить JSON текст подобный:
```json
{
    "idAccount": 1,
    "amount": 50
}
```
### Для внесения денегь
POST http://localhost:8080/spring_course_rest/api/account/put <br/>
В тело включить JSON текст подобный:
```json
{
    "idAccount": 1,
    "amount": 50
}
```
