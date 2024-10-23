FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/monolit-0.0.1-SNAPSHOT.jar /app/monolit.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/monolit.jar"]