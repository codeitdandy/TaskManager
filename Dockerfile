FROM openjdk:8-jdk-alpine
ADD . /opt/app
COPY ./taskManager-0.0.1-SNAPSHOT.jar /opt/app
WORKDIR /opt/app
CMD ["java" ,"-jar","taskManager-0.0.1-SNAPSHOT.jar"]

