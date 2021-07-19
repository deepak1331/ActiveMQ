package com.deepak.learn.ActiveMQ.standalone.resource;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/joke")
public class Producer2 {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("joke")
	Queue queue;

	@GetMapping("/{input}")
	public String input(@PathVariable("input") final String input) {
		jmsTemplate.convertAndSend(queue, input);
		return "Joke Published !";
	}
}
