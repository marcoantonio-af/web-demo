package com.example.helloworldspringbootstarter.demo;

/**
 * @author zj
 * @version 1.0
 * @description TODO
 * @create 2019/4/19 15:20
 **/
public class PersonService {
    private PersonProperties properties;

    public PersonService() {
    }

    public PersonService(PersonProperties properties) {
        this.properties = properties;
    }

    public void sayHello(){
        System.out.println("大家好，我叫: " + properties.getName() + ", 今年" + properties.getAge() + "岁"
                + ", 性别: " + properties.getSex());
    }
}
