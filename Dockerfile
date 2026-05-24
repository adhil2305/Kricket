FROM eclipse-temurin:17

WORKDIR /app

COPY . .


EXPOSE 8080

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]