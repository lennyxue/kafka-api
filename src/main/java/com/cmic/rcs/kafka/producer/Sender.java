package com.cmic.rcs.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public ListenableFuture<SendResult<String, String>> send(String topic, String payload) {
		LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
		return kafkaTemplate.send(topic, payload);
	}
}
