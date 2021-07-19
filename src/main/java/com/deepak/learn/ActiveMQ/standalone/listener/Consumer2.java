package com.deepak.learn.ActiveMQ.standalone.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

	@JmsListener(destination = "jokeOfTheDay")
	public void consume(String joke) {
		System.out.println("Today's Joke is received : " + joke);
	}
}
