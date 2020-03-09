# Kafka-Docker-SimpleProducerConsumer

## Pre-Requisites
* modify the KAFKA_ADVERTISED_HOST_NAME in docker-compose.yml to match your docker host IP

## Usage
Start a cluster:
* $ docker-compose up

In a new terminal:
* $ docker run -it consumer:1 /bin/bash
* $ start-consumer/sh YOUR_HOST_IP:9092
(In my case: start-consumer 10.0.2.15:9092)

In a new terminal:
* $ docker run -it producer:1 /bin/bash
* $ start-producer/sh YOUR_HOST_IP:9092
(In my case: start-producer 10.0.2.15:9092)
