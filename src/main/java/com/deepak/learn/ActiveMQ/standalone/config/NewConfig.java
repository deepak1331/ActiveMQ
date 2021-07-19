package com.deepak.learn.ActiveMQ.standalone.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class NewConfig {

	@Value("${spring.activemq.broker-url}")
	String brokerUrl;

	@Bean("joke")
	public Queue queue() {
		return new ActiveMQQueue("jokeOfTheDay");
	}

	public ActiveMQConnectionFactory getConnection() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
		return factory;
	}

	public JmsTemplate getJmsTemplate() {
		return new JmsTemplate(getConnection());
	};
}
