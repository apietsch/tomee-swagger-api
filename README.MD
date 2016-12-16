# tomee-swagger-api

This is a Java EE 7 Rest API project example build with Tomee, Swagger and Postgresql.

## Run the project

To run the project you need Maven and Postgres SQL installed in your system. Create the database with the help of the included sql file (or you can also generate your own) and config the url and crendentials in resources.xml (main/webapp/WEB-INF/resources.xml). Then you only need to run:

```
mvn package tomee:run
```
