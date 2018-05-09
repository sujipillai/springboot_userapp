# docker file for running spring boot app
FROM openjdk:8

COPY target/user-app.jar user-app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "user-app.jar"]