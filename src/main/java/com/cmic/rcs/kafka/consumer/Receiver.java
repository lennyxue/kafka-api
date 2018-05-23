package com.cmic.rcs.kafka.consumer;

import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	
	@KafkaListener(topics = "${kafka.topic.rcs}")
	public void receive1(ConsumerRecord<?, ?> consumerRecord) {
		Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
		if (kafkaMessage.isPresent()) {
			LOGGER.info("rcs1 received payload='{}'", kafkaMessage.get());
		}
	}

//	@KafkaListener(id = "rcs2", topics = "${kafka.topic.rcs}")
//	public void receive2(ConsumerRecord<?, ?> consumerRecord) {
//		Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
//		if (kafkaMessage.isPresent()) {
//			LOGGER.info("rcs2 received payload='{}'", kafkaMessage.get());
//		}
//	}
}
