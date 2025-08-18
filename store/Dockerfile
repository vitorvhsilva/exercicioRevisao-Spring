FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/store-*.jar /app/store.jar

ENV SPRING_PROFILES_ACTIVE=oracle
ENV SPRING_DATASOURCE_PASSWORD=Fiap25

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", "-jar", "/app/store.jar"]
