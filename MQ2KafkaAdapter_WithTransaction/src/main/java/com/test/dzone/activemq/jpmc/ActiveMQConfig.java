package com.test.dzone.activemq.jpmc;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class ActiveMQConfig {
	public static final String HELLO_QUEUE = "hello.queue";
	public static final String ERROR_QUEUE = "error.queue";

	@Bean
	public Queue helloJMSQueue() {
		return new ActiveMQQueue(HELLO_QUEUE);
	}

	@Bean
	public Queue errorQueue() {
		return new ActiveMQQueue(ERROR_QUEUE);
	}

	@Bean
	public ActiveMQConnectionFactory jmsConnectionfactory() {

		ActiveMQConnectionFactory activeFactory = new ActiveMQConnectionFactory();
		activeFactory.setBrokerURL("tcp://localhost:61616");

		RedeliveryPolicy pol = new RedeliveryPolicy();
		pol.setMaximumRedeliveries(-1);
		pol.setBackOffMultiplier(5);
		pol.setUseExponentialBackOff(true);
		pol.setInitialRedeliveryDelay(2000);

		activeFactory.setRedeliveryPolicy(pol);
		return activeFactory;
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
