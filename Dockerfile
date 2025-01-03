# First stage: Build the Spring Boot application
FROM maven:3.9.9-amazoncorretto-21-alpine AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Copy the source code to the container
COPY src ./src

# Build the application, skipping tests
RUN mvn package -DskipTests

# Second stage: Create a minimal image with OpenJDK 21
FROM amazoncorretto:21-alpine

# Set working directory to Tomcat's webapps directory
WORKDIR /usr/local/tomcat/webapps/

# Copy the built WAR file from the builder stage
COPY --from=builder /app/target/Spring_Hibernet-1-0.0.1-SNAPSHOT.war app.war

# Expose the custom port
EXPOSE 9795

# Start the application
ENTRYPOINT ["java", "-jar", "app.war"]