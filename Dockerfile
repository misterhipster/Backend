FROM eclipse-temurin:17-jre-jammy
COPY target/demo2-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
