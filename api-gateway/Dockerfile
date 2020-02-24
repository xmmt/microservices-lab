FROM openjdk:8-jre-alpine
COPY ./build/libs/api-gateway-0.0.1-SNAPSHOT.jar /api-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8111
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "api-gateway-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]