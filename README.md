## Spring Boot REST Service 2

> ### mybatis, mysql, postman 프로그램을 통해서 유저를 CRUD 하는 REST Service

* 프로젝트 형태
    * Project: Maven Project
    * Language: Java 11
    * Spring Boot: 2.6.4
    * Packaging: Jar
    * Dependencies
        * Spring Web
        * MyBatis Framework
        * MySQL Driver

* USER table DDL
```
create table USER
(
    id         int auto_increment
    primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int          not null
);
```