package com.example.demo.mapper;

import com.example.demo.data.YjServerPrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YjServerPriceMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(YjServerPrice record);

    int insertSelective(YjServerPrice record);

    YjServerPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YjServerPrice record);

    int updateByPrimaryKey(YjServerPrice record);
}