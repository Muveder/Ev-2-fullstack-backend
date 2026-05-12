FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Esto copia el archivo que genera Maven al compilar
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]