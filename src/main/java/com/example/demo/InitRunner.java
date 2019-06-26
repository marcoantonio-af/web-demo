package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(InitRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("初始化runner .................");
    }
}
