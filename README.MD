# tomee-swagger-api

This is a **Java EE 7 Rest API** project example build on top of Tomee 7.0.2, Swagger and Postgresql.

## Install

To run the project you need Maven and Postgres SQL installed in your system. Create the database with the help of the included *database.sql* file (or you can also generate your own) and config the url and crendentials in *resources.xml* (main/webapp/WEB-INF/resources.xml). Then run:

```
mvn package tomee:run
```

To make this project i took several ideas from [here](https://github.com/rmannibucau/swagger-in-tomee)

## Generate SQL from entities

To automatically generate sql DML file to create the database, open-jpa maven plugin has been included. If you create new entities don't forget to include them in the persistence.xml file.

```
mvn openjpa:sql
```
