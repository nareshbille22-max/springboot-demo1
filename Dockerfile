# Use an official OpenJDK 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from your local target folder to the container
COPY target/springboot-demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Render detects this automatically)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
