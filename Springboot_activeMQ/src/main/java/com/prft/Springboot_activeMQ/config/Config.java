package com.prft.Springboot_activeMQ.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("SpringbootActiveMQ.queue");
	}

	/*
	 * A ConnectionFactory is an an Administered object, and is used for creating
	 * Connections.
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory obj = new ActiveMQConnectionFactory();
		obj.setBrokerURL("tcp://localhost:61616");
		return obj;
	}

	/*
	 * The JmsTemplate is a central class from the Spring core package.JmsTemplate
	 * is a helper class that simplifies receiving and sending of messages through
	 * JMS,Java Message Service is an API which supports the formal communication
	 * called as messaging between computers on a network.
	 */
	@Bean 
	public JmsTemplate jmsTemplate() {  //will create a jmstemplate with above factory
		return new JmsTemplate(activeMQConnectionFactory());
	}

}
