package com.test.dzone.activemq.jpmc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.test.dzone.activemq.jpmc")
@EnableIntegration
@IntegrationComponentScan("com.test.dzone.activemq.jpmc")
public class AppConfiguration {

	/**
     * Creates a new cargoGWDefaultRequest Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel helloChannel() {
		return new DirectChannel();
	}
	
	
	@Bean
	public MessageChannel inputToKafka() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel errorChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel rethrowChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel errorOutputChannel() {
		return new DirectChannel();
	}
}
