FROM maven:3.9.8-eclipse-temurin-21 as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /usr/src/app/target/test-ecommerce-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

RUN groupadd -r app && useradd --no-log-init -r -g app app
USER app