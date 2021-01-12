#
# Build stage
#
FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Package stage
#
FROM openjdk:8
COPY --from=build /usr/src/app/target/satellite-api-0.0.1-SNAPSHOT.jar /usr/local/lib/satellite-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/satellite-api.jar"]