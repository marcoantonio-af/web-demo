package com.example.dynamicdatasource.controller;

import com.example.dynamicdatasource.dataSourceTest.DataSourceContextHolder;
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
        // 切换数据源，之后的请求会去连接池中取数据库连接，连接池不与线程绑定
         /*
          若动态设置数据源，每设置下数据源则会重新创建连接池，
          所以动态设置数据源不应该在每个方法里，这样每次请求线程进入后，都不是从连接池中获取的数据连接
        */
        DataSourceContextHolder.setDB("test");
        userService.add(user);
        return "ok";
    }

}

