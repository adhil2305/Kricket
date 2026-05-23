FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN chmod +x mvn    
RUN ./mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/app.jar"]