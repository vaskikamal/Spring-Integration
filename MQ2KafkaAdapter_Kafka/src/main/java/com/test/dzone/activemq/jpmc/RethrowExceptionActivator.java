package com.test.dzone.activemq.jpmc;

import org.springframework.messaging.Message;

public class RethrowExceptionActivator {
	public void rethrow(Message<Exception> msg) throws Exception {
		throw msg.getPayload();
	}

}
