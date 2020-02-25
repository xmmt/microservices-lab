FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/payment-0.0.1-SNAPSHOT.jar /payment-0.0.1-SNAPSHOT.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "payment-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]