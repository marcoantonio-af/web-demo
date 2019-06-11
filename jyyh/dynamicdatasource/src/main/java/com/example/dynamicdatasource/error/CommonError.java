package com.example.dynamicdatasource.error;

public interface CommonError {
     int getErrCode();
     String getErrMsg();
     CommonError setErrMsg(String errMsg);

}
