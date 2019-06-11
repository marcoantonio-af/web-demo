package com.example.dynamicdatasource.test;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Test implements TestInterface{

    public void setData(String msg){
    ResultBean resultBean = result();
    resultBean.addF(msg);
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public ResultBean result() {
        return (ResultBean) getRequest().getAttribute(ResultBean.WEB_RESULT_BEAN);
    }
}
