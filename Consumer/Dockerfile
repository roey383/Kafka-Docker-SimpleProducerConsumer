FROM adoptopenjdk
COPY . .
WORKDIR /src
ENV PATH=${PATH}:/src
RUN cd .. \
	&& javac -cp "libs/*" src/consumer/KafkaSimpleConsumer.java \
	&& cd src \
	&& chmod 777 start-consumer.sh
