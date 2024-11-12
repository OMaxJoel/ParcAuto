# Étape 1 : Construction de l'application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Étape 2 : Création de l'image exécutable
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
