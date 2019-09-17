FROM openjdk:8-jdk-alpine

ARG APP_FILE

ENV JVM_OPTIONS=""
ENV DELETE_ON_EXIT="true"
ENV NODES = "3"
ENV ZOOKEEPER_PORT = "2181"
ENV KAFKA_PORT = "9092"

COPY /target/$APP_FILE app.jar

ENTRYPOINT [ "sh", "-c", "java $JVM_OPTIONS -jar app.jar -n $ENVIRONMENT" ]
