# Utiliser une image de base Java 17
FROM openjdk:17-jdk-slim as builder

# Définir le répertoire de travail dans le container
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copier le reste des fichiers du projet
COPY src ./src

# Construire l'application
RUN ./mvnw clean package -DskipTests

# Étape de production
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier jar depuis l'étape builder
COPY --from=builder /app/target/*.jar app.jar

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Exposer le port 8080
EXPOSE 8080
