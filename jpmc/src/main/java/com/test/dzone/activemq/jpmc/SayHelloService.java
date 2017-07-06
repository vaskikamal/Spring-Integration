package com.test.dzone.activemq.jpmc;

import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.stereotype.Service;

@Service
public class SayHelloService {
	public void sayHello(TextMessage name) {
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("##  " + ((ActiveMQTextMessage) name) + "!!!");
		System.out.println("################################");
		System.out.println("################################");
		System.out.println("################################");
	}
}
