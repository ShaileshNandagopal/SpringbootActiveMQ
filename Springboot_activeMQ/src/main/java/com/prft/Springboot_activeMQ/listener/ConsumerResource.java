package com.prft.Springboot_activeMQ.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerResource {

	//to listen to the queue that we created
	@JmsListener(destination = "SpringbootActiveMQ.queue")
	public void consume(String message) {
		System.out.println("Recieved message: "+message);
	}
}
