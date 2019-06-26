package com.example.demo;

import com.example.demo.config.ConfigTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class A {
    @Resource
    private ConfigTest configTest;

    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public void sayHello(String s, HttpServletRequest request, HttpServletResponse response){
        request.getParameterMap();
       // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("config:" + configTest.getName() + configTest.getUrl());
        System.out.println("hello"+s);
        response.setStatus(302);
        response.setHeader("Location", "www.baidu.com");
    }

    @RequestMapping(value = "/git/org/orguser/orgManagementRestService!disableBatchOrgs.do",method = RequestMethod.POST)
    public String disableBatchOrgs(String orgIds){

        // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("config:" + configTest.getName() + configTest.getUrl());
        System.out.println("hello"+orgIds);
        return "/page/index.html";
    }






}
