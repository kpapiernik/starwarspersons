FROM openjdk:17
EXPOSE 8080
ADD target/swapi-app.jar swapi-app.jar
ENTRYPOINT ["java", "-jar", "swapi-app.jar"]