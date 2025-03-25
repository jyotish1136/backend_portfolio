
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.yml /app/config/application.yml
EXPOSE 8080
ENV SPRING_CONFIG_LOCATION=/app/config/
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=/app/config/application.yml"]