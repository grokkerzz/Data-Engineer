package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerialization");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerialization");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 1000; i ++) {
            ProducerRecord<String, String> data;
            if (i%2 == 0) {
                data = new ProducerRecord<String, String>("even", 0, Integer.toString(i), String.format("%d is even", i));
            } else {
                data = new ProducerRecord<String, String>("old", 0, Integer.toString(i), String.format("%d is old", i));
            }

            kafkaProducer.send(data);
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        kafkaProducer.close();
    }
}
