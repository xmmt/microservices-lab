#!/bin/bash

cd eureka
mvn package
cd ../orders
mvn package
cd ../warehouse
mvn package
cd ../payment
mvn package
cd ../api-gateway
./gradlew build -x test

docker-compose build
docker-compose up --force-recreate --build
