# boot-camp

1. `Spring Boot`
2. `Mongo`
3. `Spring Hibernate/JPA Postgres`
4. `Rest Api`
5. `Data Transfer Object`
6. `React`
7. `Swagger Api 3`
8. `Docker`

## Configuration

Postgres and Mongo database connections can be found in here,
https://github.com/er310/boot-camp/blob/master/api/src/main/resources/application.properties

## Run via Docker

`docker-compose up -build`

## App Links

http://localhost:3000

http://localhost:8080/v1/swagger-ui/index.html

## Switching Datasources between Postgres and Mongo

Configure using application.properties 

`spring.db.dialect=mongo` OR `spring.db.dialect=postgres`
