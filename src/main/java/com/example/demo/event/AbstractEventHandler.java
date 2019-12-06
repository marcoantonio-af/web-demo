package com.example.demo.event;

import org.springframework.stereotype.Component;

/**
 * @author zhangjie [zhangjie02@yinhai.com]
 */
@Component
public interface AbstractEventHandler {

	void onEvent(EventMessage eventMessage);
}
