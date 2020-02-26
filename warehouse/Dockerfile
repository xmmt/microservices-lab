FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/warehouse-0.0.1-SNAPSHOT.jar /warehouse-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "warehouse-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]