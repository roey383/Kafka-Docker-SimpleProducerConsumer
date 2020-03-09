FROM adoptopenjdk
COPY . .
WORKDIR /src
ENV PATH=${PATH}:/src
RUN cd .. \
	&& javac -cp "libs/*" src/producer/KafkaSimpleProducer.java \
	&& cd src \
	&& chmod 777 start-producer.sh
