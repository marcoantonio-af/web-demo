package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Async
    public void syncnMethod() {
        try {
            Thread.sleep(5000);
            System.out.println("55555");
        }catch (Exception e){

        }
    }
}
