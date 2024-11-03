
FROM openjdk:23-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y findutils

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

COPY src src

RUN chmod +x gradlew

RUN ./gradlew bootJar

COPY build/libs/evalartTest-0.0.1-SNAPSHOT.jar app.jar

#COPY src/main/resources/application.yml app/src/main/resources/application.yml

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
