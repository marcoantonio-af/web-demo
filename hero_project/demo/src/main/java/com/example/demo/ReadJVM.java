package com.example.demo;

import java.util.Properties;

public class ReadJVM {
    public static void main(String[] args) {
        Properties pps = System.getProperties();
        pps.list(System.out);
        }
}
