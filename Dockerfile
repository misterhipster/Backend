FROM openjdk:17-jre-slim
COPY target/backend.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080