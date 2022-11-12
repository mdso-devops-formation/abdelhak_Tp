#Stage 1

FROM maven:3.8.3-openjdk-17 as build

WORKDIR /opt/demo

COPY pom.xml .

RUN mvn dependency:go-offline

COPY ./src ./src

RUN mvn clean install -Dmaven.test.skip=true
#Stage 2

FROM openjdk:17-alpine

WORKDIR /opt/demo

COPY --from=build /opt/demo/target/demo.jar /opt/demo
