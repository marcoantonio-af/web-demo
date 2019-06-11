package com.example.dynamicdatasource.dataobject;

public class MiddlewarePo {
    private String middlewareId;

    private String hostId;

    private String hostIp;

    private String middlewareType;

    private Integer middlewarePort;

    public String getMiddlewareId() {
        return middlewareId;
    }

    public void setMiddlewareId(String middlewareId) {
        this.middlewareId = middlewareId == null ? null : middlewareId.trim();
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId == null ? null : hostId.trim();
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp == null ? null : hostIp.trim();
    }

    public String getMiddlewareType() {
        return middlewareType;
    }

    public void setMiddlewareType(String middlewareType) {
        this.middlewareType = middlewareType == null ? null : middlewareType.trim();
    }

    public Integer getMiddlewarePort() {
        return middlewarePort;
    }

    public void setMiddlewarePort(Integer middlewarePort) {
        this.middlewarePort = middlewarePort;
    }
}