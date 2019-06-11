package com.example.dynamicdatasource.dataobject;

public class UserPasswordDO {
    private Integer id;

    private String encptPassword;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncptPassword() {
        return encptPassword;
    }

    public void setEncptPassword(String encptPassword) {
        this.encptPassword = encptPassword == null ? null : encptPassword.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}