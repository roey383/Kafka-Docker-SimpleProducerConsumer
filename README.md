# Kafka-Docker-SimpleProducerConsumer

## Pre-Requisites
* modify the KAFKA_ADVERTISED_HOST_NAME in docker-compose.yml to match your docker host IP

## Usage
Start a cluster:
* $ docker-compose up

In a new terminal:
* $ docker run -it consumer:1 /bin/bash
(will enter container bash)
*  start-consumer.sh YOUR_HOST_IP:9092 <br />
(In my case: $ start-consumer.sh 10.0.2.15:9092)

In a new terminal:
* $ docker run -it producer:1 /bin/bash
(will enter container bash)
* $ start-producer.sh YOUR_HOST_IP:9092 <br />
(In my case: $ start-producer.sh 10.0.2.15:9092)
