#Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . . 
RUN mvn clean package -DskipTests
#RUN mvn clean package -DskipTests

#Stage 2: Create the lightweight runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Assumes the build produces a jar named 'power-calculator-0.0.1-SNAPSHOT.jar'
# COPY --from=build /app/target/power-calculator-0.0.1-SNAPSHOT.jar power-calculator.jar
# ENTRYPOINT ["java", "-jar", "power-calculator.jar"]
COPY --from=build /app/target/power-calculator-*.jar ./
ENTRYPOINT ["java", "-jar", "power-calculator-*.jar"]