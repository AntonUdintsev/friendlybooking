FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/friendlybooking-0.0.1-SNAPSHOT.jar /app/friendlybooking.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/friendlybooking.jar"]