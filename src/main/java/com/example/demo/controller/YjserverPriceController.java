package com.example.demo.controller;

import com.example.demo.service.YjServerPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YjserverPriceController {

    @Autowired
    private YjServerPriceService yjServerPriceService;

    @RequestMapping(value = "/selectData.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String selectData(){
        yjServerPriceService.selectData();
        return "success";
    }

}
