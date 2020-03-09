package producer;

//import util.properties packages
import java.util.Properties;
import java.util.Scanner;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;
//import simple producer packages
import org.apache.kafka.clients.producer.Producer;
//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaSimpleProducer {

	public static void main(String[] args) throws Exception {

		// create instance for properties to access producer configs
		Properties props = new Properties();

		// Assign localhost id
		// props.put("bootstrap.servers", "10.0.2.15:9092");
		props.put("bootstrap.servers", "10.0.2.15:9092");

		// Set acknowledgements for producer requests.
		props.put("acks", "all");

		// If the request fails, the producer can automatically retry,
		props.put("retries", 0);

		// Specify buffer size in config
		props.put("batch.size", 16384);

		// Reduce the no of requests less than 0
		props.put("linger.ms", 1);

		// The buffer.memory controls the total amount of memory available to the
		// producer for buffering.
		props.put("buffer.memory", 33554432);

		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//		Thread.currentThread().setContextClassLoader(null);
		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		producer.send(new ProducerRecord<String, String>("FirstTopic", "Key1", "Hello"));
		producer.send(new ProducerRecord<String, String>("SecondTopic", "Key2", "World"));
		System.out.println("Message sent successfully");
		
		//while (true);

		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Enter topic: ");
			String topic = sc.nextLine();
			
			System.out.print("Enter key: ");
			String key = sc.nextLine();
			
			System.out.print("Enter value: ");
			String value = sc.nextLine();
			
			producer.send(new ProducerRecord<String, String>(topic, key, value));
			
		}
		
		
//		producer.close();
//            
//      for(int i = 0; i < 10; i++)
//         producer.send(new ProducerRecord<String, String>(topicName, 
//            Integer.toString(i), Integer.toString(i)));
//               System.out.println("Message sent successfully");
//               producer.close();
	}
}