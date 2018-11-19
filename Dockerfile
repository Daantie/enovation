FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/assessment-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} spring-boot.jar

ENTRYPOINT ["java","-jar","spring-boot.jar"]