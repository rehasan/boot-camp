#
# Build stage
FROM maven:3.6.3-jdk-8-slim AS build
COPY src /boot-camp/maven/src
COPY pom.xml /boot-camp/maven
RUN mvn -f /boot-camp/maven/pom.xml clean package

#
# Package stage
FROM openjdk:8-jdk-alpine

WORKDIR /boot-camp/api

# Refer to Maven build -> build filename
ARG JAR_FILE=/boot-camp/maven/target/api-0.0.1-SNAPSHOT.jar

COPY --from=build ${JAR_FILE} /boot-camp/api/api.jar

# java -jar api.jar
ENTRYPOINT ["java","-jar","api.jar"]

ENV PORT 8080

EXPOSE 8080