package com.cmic.rcs.kafka;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import com.cmic.rcs.kafka.consumer.Receiver;
import com.cmic.rcs.kafka.producer.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTest {

	private static String TOPIC="TEST";

	@Autowired
	private Sender sender;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC);

	@Test
	public void testReceive() throws Exception {
		sender.send(TOPIC, "Hello RCS1!");
	}
}
