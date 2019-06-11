package com.example.dynamicdatasource.controller;

import com.example.dynamicdatasource.dao.UserDOMapper;
import com.example.dynamicdatasource.dataobject.UserDO;
import com.example.dynamicdatasource.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by meridian on 2018/9/10.
 */
@Controller
@RequestMapping("api/cxy")
public class UserController {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;



    @RequestMapping("/save")
    @ResponseBody
    public String save(UserDO user) throws BusinessException {
        userDOMapper.insertSelective(user);
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        System.out.println(userDO.toString());
        userDOMapper.deleteByPrimaryKey(1);
        return "ok";
    }

}

