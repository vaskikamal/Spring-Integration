package com.test.dzone.activemq.jpmc;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class ActiveMQConfig {
	public static final String HELLO_QUEUE = "hello.queue";

	@Bean
	public Queue helloJMSQueue() {
		return new ActiveMQQueue(HELLO_QUEUE);
	}

	@Bean
	public ActiveMQConnectionFactory jmsConnectionfactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	@Bean
	public DefaultMessageListenerContainer requestListenerContainer() {

		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(jmsConnectionfactory());
		container.setSessionTransacted(true);
		container.setDestination(helloJMSQueue());
		container.setExposeListenerSession(false);
		container.setRecoveryInterval(5000);
		return container;
	}

}
