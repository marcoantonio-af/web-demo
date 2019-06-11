package com.example.dynamicdatasource.test;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ResultBean {
    public static final String WEB_RESULT_BEAN = "_WEB_RESULT_BEAN";
    private String msg = "";
    private int code = HttpServletResponse.SC_OK;
    private List<Error> errors = null;

    public ResultBean addF(String msg){
        if (!msg.equals("")){
            this.msg = msg;
        }
        return this;
    }
}
