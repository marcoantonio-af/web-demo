package com.example.demo;


import com.example.demo.service.YjServerPriceService;

public interface T extends YjServerPriceService{
   // void a();

     String b(String c);
    default void ss(){
        System.out.println("ddd");
    }


}
