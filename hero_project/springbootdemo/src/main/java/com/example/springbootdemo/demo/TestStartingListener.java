package com.example.springbootdemo.demo;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zj
 * @version 1.0
 * @description TODO
 * @create 2019/4/9 15:25
 **/
public class TestStartingListener implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("ApplicationStartingEvent············");
    }
}
