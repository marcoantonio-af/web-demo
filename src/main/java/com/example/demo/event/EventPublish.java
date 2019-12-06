package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangjie [zhangjie02@yinhai.com]
 */
@Component
public class EventPublish {

	@Resource
	private AbstractEventHandler abstractEventHandler;

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * 非注解式事件发布
	 *
	 * @param eventId 事件ID
	 * @param object  事件内容
	 */
	public void publish(String eventId, Object object) {
		EventMessage eventMessage = new EventMessage();
		eventMessage.setEventSource(object);

		if (!applicationContext.containsBean(AnnotationBeanRegistry.SYNCHRONIZATION + eventId)) {
			return;
		}
		//获取到同步注解的类
		List<String> consumerList = (List<String>) applicationContext.getBean(AnnotationBeanRegistry.SYNCHRONIZATION + eventId);

		AbstractEventHandler handler;
		for (String c : consumerList) {
			handler = (AbstractEventHandler) applicationContext.getBean(c);
			handler.onEvent(eventMessage);
		}

	}
}
