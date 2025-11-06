FROM eclipse-temurin:17-jdk
ARG JAR_FILE=target/backend_restaurant-0.0.1.jar
COPY ${JAR_FILE} app_restaurant.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_restaurant.jar"]