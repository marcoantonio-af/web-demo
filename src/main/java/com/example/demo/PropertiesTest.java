package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("G:\\hero_project\\demo\\src\\main\\resources\\application-dev.properties"));
            System.out.println("" + properties.getProperty("server.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
