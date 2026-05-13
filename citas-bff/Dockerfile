# Usamos una imagen de Java ligera
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo .jar (asegúrate de haber hecho el build antes)
COPY target/*.jar app.jar

# Exponemos el puerto del BFF
EXPOSE 8085

# Comando para arrancar
ENTRYPOINT ["java", "-jar", "app.jar"]