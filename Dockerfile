#Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . . 
RUN mvn clean package -DskipTests

#Stage 2: Create the lightweight runtime image