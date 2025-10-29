# Small, secure base JRE (change 17 -> 21 if your app uses Java 21)
FROM eclipse-temurin:21-jre-alpine

# Run as non-root for security
RUN addgroup -S app && adduser -S app -G app
USER app

# App directory in the container
WORKDIR /app

# Copy the jar (update the name if your jar differs)
COPY target/WeatherApplication-0.0.1-SNAPSHOT.jar app.jar

# Expose the Spring Boot port
EXPOSE 8080

# Pass JVM flags via JAVA_OPTS if needed, else it’s empty
ENV JAVA_OPTS=""

# Start the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
