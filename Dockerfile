# Dockerfile backend
FROM eclipse-temurin:17-jdk
#COPY target/
WORKDIR /app

#ARG JAR_FILE=target/backend_restaurant-0.0.1.jar

#COPY target/backend_restaurant-0.0.1.jar backend_restaurant.jar
COPY target/*.jar backend_restaurant.jar

#
EXPOSE 3306
#
ENTRYPOINT ["java", "-jar", "backend_restaurant.jar"]


