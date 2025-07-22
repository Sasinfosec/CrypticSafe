# Use a minimal and secure base image
FROM amazoncorretto:17.0.7-alpine

# Set a working directory
WORKDIR /app

#Testing the Github Actions
# Copy the JAR file to the working directory
COPY ./target/kode-0.0.1-SNAPSHOT.jar app.jar

# Create a non-root user and group
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Change ownership of the application files
RUN chown -R appuser:appgroup /app

# Switch to non-root user
USER appuser

# Expose only the necessary port
EXPOSE 7930

# Set a healthcheck (optional but good practice)
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
 CMD wget --no-verbose --tries=1 --spider http://localhost:9090/ || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
