# syntax=docker/dockerfile:1

# Étape de construction
FROM maven:3.8.6-openjdk-19 AS builder
WORKDIR /app

# Copier le fichier POM et les dépendances Maven pour le cache
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copier le reste du code source
COPY src ./src

# Compiler l'application
RUN mvn package -B -DskipTests=true

# Étape de création de l'image finale
FROM openjdk:19-jdk-alpine3.16
ENV NODE_ENV production
WORKDIR /app

# Ajouter un groupe et un utilisateur non privilégiés
RUN addgroup -S group && adduser -S user -G group
USER user

# Copier le fichier JAR de l'étape de construction
COPY --chown=user:group --from=builder /app/target/httpcachetest-0.0.1-SNAPSHOT.jar /app/httpcachetest-0.0.1-SNAPSHOT.jar

# Exposer le port 9001
EXPOSE 9001

# Définir la commande par défaut
CMD ["java", "-jar", "/app/httpcachetest-0.0.1-SNAPSHOT.jar"]
