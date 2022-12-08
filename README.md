# starwarspersons
***

The project shows a simple integration with external API (https://swapi.dev/)

## Technologies
***
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Postgres SQL
- Lombok
- JUnit 5
- Mockito
- AssertJ
- Docker

## Requirements
***
- Docker installed - [link](https://www.docker.com/products/docker-desktop/)
- Maven installed - [link](https://maven.apache.org/download.cgi)
- Java installed - [link](https://jdk.java.net/archive/)

## How to run application
***
First you need to download this repository to your local machine.\
Next open terminal in the project main directory and use command:
- `mvn clean install` if you want to compile code and run unit tests
- `mvn clean install -DskipTests` if you want to compile code without running unit tests\

Next make sure that your Docker app is running. Then use this command in terminal:
`docker-compose up -d --build`\
To check application logs use: `docker-compose logs -f`\
To stop application use: `docker-compose stop`


## REST API Documentation
***
You can find the Swagger UI documentation at the [link](http://localhost:8080/swagger-ui.html) after you run the application.