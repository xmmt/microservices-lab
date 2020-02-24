FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/eureka-0.0.1-SNAPSHOT.jar /eureka-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
