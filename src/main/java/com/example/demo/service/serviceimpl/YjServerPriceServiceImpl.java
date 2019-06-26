package com.example.demo.service.serviceimpl;

import com.example.demo.data.YjServerPrice;
import com.example.demo.mapper.YjServerPriceMapper;
import com.example.demo.service.YjServerPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class YjServerPriceServiceImpl implements YjServerPriceService {

    @Autowired
    YjServerPriceMapper yjServerPriceMapper;

    public void selectData(){
        YjServerPrice yjServerPrice = yjServerPriceMapper.selectByPrimaryKey(14);
        System.out.println(yjServerPrice.toString());
    }
}
