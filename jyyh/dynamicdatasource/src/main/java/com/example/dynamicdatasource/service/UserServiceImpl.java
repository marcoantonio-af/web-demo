package com.example.dynamicdatasource.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.dynamicdatasource.dao.UserDOMapper;
import com.example.dynamicdatasource.dataSourceTest.DataSourceContextHolder;
import com.example.dynamicdatasource.dataSourceTest.Ds2DynamicDataSource;
import com.example.dynamicdatasource.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

//@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;


    @Override
    public void add(UserDO user) {

//        Ds2DynamicDataSource ds2DynamicDataSource = Ds2DynamicDataSource.getInstance();
//        Map<Object,Object> dataSourceMap=new HashMap<Object, Object>();
//        DruidDataSource wdataSource = new DruidDataSource();
//        wdataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        wdataSource.setUrl("jdbc:mysql://127.0.0.1:3306/miaosha?useUnicode=true&characterEncoding=utf8");
//        wdataSource.setUsername("root");
//        wdataSource.setPassword("123456");
//
//        //连接池配置
//        wdataSource.setMaxActive(5);
//        wdataSource.setMinIdle(5);
//        wdataSource.setInitialSize(5);
//
//        dataSourceMap.put("2", wdataSource);
//        DataSourceContextHolder.setDB("2");
//        ds2DynamicDataSource.setTargetDataSources(dataSourceMap);


        userDOMapper.insertSelective(user);
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        System.out.println(userDO.toString());
//       userDOMapper.insertSelective(user);
        userDOMapper.deleteByPrimaryKey(1);
    }


}
