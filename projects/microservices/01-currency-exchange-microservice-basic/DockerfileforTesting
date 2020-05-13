FROM maven:3.6.3-jdk-8-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/projects/microservices/01-currency-exchange-microservice-basic/pom.xml clean test

