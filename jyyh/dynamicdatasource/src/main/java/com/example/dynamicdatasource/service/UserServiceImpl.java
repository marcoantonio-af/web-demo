package com.example.dynamicdatasource.service;

import com.example.dynamicdatasource.dao.UserDOMapper;
import com.example.dynamicdatasource.dataSourceTest.DataSourceContextHolder;
import com.example.dynamicdatasource.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public void add(UserDO user) {


       /* 切换数据源，之后的请求会去连接池中取数据库连接，连接池不与线程绑定。
          若动态设置数据源，每设置下数据源则会重新创建连接池，
          所以动态设置数据源不应该在每个方法里，这样每次请求线程进入后，都不是从连接池中获取的数据连接
        */
       DataSourceContextHolder.setDB("test");

        // 操作数据库
        userDOMapper.insertSelective(user);
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        System.out.println(userDO.toString());
//       userDOMapper.insertSelective(user);
        userDOMapper.deleteByPrimaryKey(1);
    }


}
