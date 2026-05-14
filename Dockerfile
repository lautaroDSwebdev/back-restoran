# ETAPA 1: Compilación (Build)
# Usamos una imagen que tenga Maven y Java 17 para construir el proyecto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos el archivo de configuración de Maven
COPY pom.xml .
# Copiamos el código fuente
COPY src ./src

# Ejecutamos el comando de empaquetado (esto crea el .jar dentro de la imagen)
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Run)
# Usamos una imagen de Java 17 ligera para correr la app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiamos el .jar generado en la etapa anterior a esta nueva imagen
COPY --from=build /app/target/*.jar backend_restaurant.jar

# Exponemos el puerto del BACKEND (Spring Boot suele usar 8080)
# Ojo: 3306 es para MySQL, tu app de Java suele ir por el 8080 o el que definas en properties
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend_restaurant.jar"]