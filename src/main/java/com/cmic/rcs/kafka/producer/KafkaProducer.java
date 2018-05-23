package com.cmic.rcs.kafka.producer;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@EnableScheduling
public class KafkaProducer {

	@Value("${kafka.topic.rcs}")
	private String TOPIC;
	
	@Autowired
	private Sender sender;
	
    @Scheduled(cron = "*/1 * * * * ?")
    public void send(){
        String message = String.valueOf((new Date()).getTime());
        ListenableFuture<?> future = sender.send(TOPIC, message);
        future.addCallback(o -> 
        					  System.out.println("send message success: " + message), 
        				   throwable -> 
        					  System.out.println("send message failed: " + message));
    }

}
