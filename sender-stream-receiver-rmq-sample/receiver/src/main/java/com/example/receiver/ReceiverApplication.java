package com.example.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverApplication.class, args);
	}

	@RabbitListener(queues = "cloud-stream-test")
	public void receive(Message msg) {
		String txt = new String(msg.getBody());
		Logger logger = LoggerFactory.getLogger(ReceiverApplication.class);
		logger.info(txt);
	}
}
