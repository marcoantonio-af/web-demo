package com.example.demo.event.test;

import com.example.demo.event.EventPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {


	@Autowired
	private EventPublish eventPublish;


	@RequestMapping(value = "/aaa.do", method = {RequestMethod.GET, RequestMethod.POST})
	private void a() {
		eventPublish.publish("EventConsumeTestConsumer","dsfsfsfdf");
	}
}
