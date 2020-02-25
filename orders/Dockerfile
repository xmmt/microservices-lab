FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/orders-0.0.1-SNAPSHOT.jar /orders-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "orders-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]