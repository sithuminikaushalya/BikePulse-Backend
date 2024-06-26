# FROM maven:3-openjdk-17 as build
# COPY . .
# RUN mvn clean package -DskipTests
#
# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /target/backend-0.0.1-SNAPSHOT.jar backend.jar
# EXPOSE 8095
# ENTRYPOINT ["java", "-jar", "backend.jar"]

# Build stage
FROM maven:3-openjdk-17 AS build
WORKDIR /app

# Copy the project files into the Docker container
COPY . .
# Run Maven to build the project and create the JAR file
RUN mvn clean package -DskipTests

# Debugging step to list the contents of the target directory
RUN ls -la /app/target

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose port 8080
EXPOSE 8095

# Set the entry point to run the JAR file with Java
ENTRYPOINT ["java", "-jar", "app.jar"]
