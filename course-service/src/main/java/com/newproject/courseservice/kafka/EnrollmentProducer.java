package com.newproject.courseservice.kafka;

import com.newproject.datatype.dto.EnrollmentEvent;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class EnrollmentProducer implements CommandLineRunner {

    final Random r = new Random();
    private KafkaProducer<String, EnrollmentEvent> producer;
    private static final String defaultTopic = "studentEnrollmentTopic";
    private static final boolean waitAck = true;
    private static final String serverAddr = "localhost:9092";

    @Override
    public void run(String... args) throws Exception {
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddr);

        //TODO: check json serializer
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new JsonSerializer<EnrollmentEvent>());

        producer = new KafkaProducer<>(props);
    }

    public void sendEvent(EnrollmentEvent event){
        final String key = "Key" + r.nextInt(1000);
        final ProducerRecord<String, EnrollmentEvent> record = new ProducerRecord<>(defaultTopic, key, event);
        final Future<RecordMetadata> future = producer.send(record);

        if (waitAck) {
            try {
                RecordMetadata ack = future.get();
                System.out.println("Ack for topic " + ack.topic() + ", partition " + ack.partition() + ", offset " + ack.offset());
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
        }
    }
}
