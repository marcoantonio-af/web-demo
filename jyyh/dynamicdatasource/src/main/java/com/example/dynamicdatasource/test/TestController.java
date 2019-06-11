package com.example.dynamicdatasource.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController extends Test{

    @RequestMapping("/user")
    public void setM(){
        String msg = "张杰test";
        setData(msg);
    }

    public static void main(String[] args) {
             List<String> a = Arrays.asList("");
             System.out.println(a.size());
        }
}
