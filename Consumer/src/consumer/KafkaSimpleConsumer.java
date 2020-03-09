package consumer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaSimpleConsumer {
	public static void main(String[] args) throws Exception {
		
		List<String> topicList = new LinkedList<String>();
		topicList.add("FirstTopic");
		topicList.add("SecondTopic");
		Properties props = new Properties();

		props.put("bootstrap.servers", args[0]);
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		// Kafka Consumer subscribes list of topics here.
		consumer.subscribe(topicList);

		
		// print the topic name
		System.out.println("Subscribed to topics: " + topicList);
		
		Map<String, Integer> keysCounter = new HashMap<String, Integer>();

		while (true) {
			@SuppressWarnings("deprecation")
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				
				if (!keysCounter.containsKey(record.key())) {
					keysCounter.put(record.key(), 0);
				}
				
				keysCounter.put(record.key(), keysCounter.get(record.key())+1);
				
				// print the offset,key and value for the consumer records.
				System.out.printf("topic = %s, offset = %d, key = %s, "
						+ "value = %s, counter = %d\n", 
						record.topic(), record.offset(), record.key(), 
						record.value(), keysCounter.get(record.key()));
			}
		}
	}
}