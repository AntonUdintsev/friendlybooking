FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/auth-service-0.0.1-SNAPSHOT.jar /app/auth-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]