# Usar una imagen base de Java 17
FROM openjdk:19-jdk-slim

# Argumento para el JAR de la aplicación
ARG JAR_FILE=target/*.jar

# Copiar el JAR de la aplicación al contenedor
COPY ${JAR_FILE} app.jar

# Punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]



#docker build -t alquilatusvehiculos:latest .
#docker run -p 8080:8080 alquilatusvehiculos:latest