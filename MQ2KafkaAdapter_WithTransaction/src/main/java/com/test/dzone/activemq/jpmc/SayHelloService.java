package com.test.dzone.activemq.jpmc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class SayHelloService {

	private final Logger logger = LoggerFactory.getLogger(SayHelloService.class);

	@ServiceActivator(inputChannel = "helloChannel", outputChannel="inputToKafka")
	public Message<?> sayHello(Message<?> name) {
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("##  " +  name.getPayload() + "!!!");
		System.out.println("##  " +  name.getHeaders() + "!!!");

		System.out.println("################################");
		
		System.out.println("################################");
		System.out.println("################################");
		
		return name;
		
	}
	
	@ServiceActivator(inputChannel = "errorOutputChannel")//, outputChannel="inputToKafka")
	public void sayHelloException(Message<Exception> name) {
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("##  " +  name.getPayload() + "!!!");
		System.out.println("##  " +  name.getHeaders() + "!!!");

		System.out.println("################################");
		
		System.out.println("################################");
		System.out.println("################################");
	}
}
