package com.example.demo.event.test;

import com.example.demo.event.AbstractEventHandler;
import com.example.demo.event.EventMessage;
import com.example.demo.event.annotation.Consumer;
import org.springframework.stereotype.Component;

/**
 * @author zhangjie [zhangjie02@yinhai.com]
 */
@Consumer("EventConsumeTestConsumer")
@Component
public class EventConsumeTest implements AbstractEventHandler {

	@Override
	public void onEvent(EventMessage eventMessage) {
		System.out.println("接收到的事件为"+ eventMessage.getEventSource());
	}
}
