package com.example.demo;

/**
 * @author zj
 * @version 1.0
 * @description TODO
 * @create 2019/4/17 11:19
 **/
public class ServerMonitorInfo {
    private String ip;
    private Integer cpu;
    private String cpuUsedRate;

    private String hardAll;
    private String hardUsed;
    private String hardUsedRate;

    private String memAll;
    private String memUsed;
    private String memUsedRate;

    private String swapAll;
    private String swapUsed;
    private String swapUsedRate;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public String getCpuUsedRate() {
        return cpuUsedRate;
    }

    public void setCpuUsedRate(String cpuUsedRate) {
        this.cpuUsedRate = cpuUsedRate;
    }

    public String getHardAll() {
        return hardAll;
    }

    public void setHardAll(String hardAll) {
        this.hardAll = hardAll;
    }

    public String getHardUsed() {
        return hardUsed;
    }

    public void setHardUsed(String hardUsed) {
        this.hardUsed = hardUsed;
    }

    public String getHardUsedRate() {
        return hardUsedRate;
    }

    public void setHardUsedRate(String hardUsedRate) {
        this.hardUsedRate = hardUsedRate;
    }

    public String getMemAll() {
        return memAll;
    }

    public void setMemAll(String memAll) {
        this.memAll = memAll;
    }

    public String getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(String memUsed) {
        this.memUsed = memUsed;
    }

    public String getMemUsedRate() {
        return memUsedRate;
    }

    public void setMemUsedRate(String memUsedRate) {
        this.memUsedRate = memUsedRate;
    }

    public String getSwapAll() {
        return swapAll;
    }

    public void setSwapAll(String swapAll) {
        this.swapAll = swapAll;
    }

    public String getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(String swapUsed) {
        this.swapUsed = swapUsed;
    }

    public String getSwapUsedRate() {
        return swapUsedRate;
    }

    public void setSwapUsedRate(String swapUsedRate) {
        this.swapUsedRate = swapUsedRate;
    }

    @Override
    public String toString() {
        return "ServerMonitorInfo{" +
                "ip='" + ip + '\'' +
                ", cpu=" + cpu +
                ", cpuUsedRate='" + cpuUsedRate + '\'' +
                ", hardAll='" + hardAll + '\'' +
                ", hardUsed='" + hardUsed + '\'' +
                ", hardUsedRate='" + hardUsedRate + '\'' +
                ", memAll='" + memAll + '\'' +
                ", memUsed='" + memUsed + '\'' +
                ", memUsedRate='" + memUsedRate + '\'' +
                ", swapAll='" + swapAll + '\'' +
                ", swapUsed='" + swapUsed + '\'' +
                ", swapUsedRate='" + swapUsedRate + '\'' +
                '}';
    }
}
