FROM openjdk:21

COPY /target/orquidario1-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
