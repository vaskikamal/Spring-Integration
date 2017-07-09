package com.test.dzone.activemq.jpmc;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class RethrowExceptionActivator {
	
	
	@ServiceActivator(inputChannel = "rethrowChannel")
	public void rethrow(Message<Exception> msg) throws Exception {
		throw msg.getPayload();
	}

}
