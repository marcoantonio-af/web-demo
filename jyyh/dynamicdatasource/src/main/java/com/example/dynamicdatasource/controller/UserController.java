package com.example.dynamicdatasource.controller;

import com.example.dynamicdatasource.dataobject.UserDO;
import com.example.dynamicdatasource.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("api/cxy")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/save")
    @ResponseBody
    public String save(UserDO user) {
        userService.add(user);
        return "ok";
    }

}

