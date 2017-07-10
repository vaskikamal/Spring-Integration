package com.test.dzone.activemq.jpmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:/spring/si-config.xml")
public class JpmcApplication_ActiveMQ {
	public static void main(String[] args) {
		SpringApplication.run(JpmcApplication_ActiveMQ.class, args);
	}
}
