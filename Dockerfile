FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package =DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/parcauto-1.0-SNAPSHOT parcauto.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/parcauto.jar"]