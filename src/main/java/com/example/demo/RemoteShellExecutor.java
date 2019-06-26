package com.example.demo;

import ch.ethz.ssh2.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * java 执行 远程linux 命令
 */
public class RemoteShellExecutor {

    private Connection conn;
    private String ip;
    private String username;
    private String password;
    private static final int TIME_OUT = 0;// 表示不超时

    /**
     * 构造函数
     *
     * @param ip       远程ip
     * @param username 远程机器用户名
     * @param password 远程机器密码
     */
    public RemoteShellExecutor(String ip, String username, String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
    }

    /**
     * 登录
     *
     * @return
     * @throws IOException
     */
    private boolean login() throws IOException {
        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(username, password);
    }

    /**
     * 执行脚本
     *
     * @param shell
     * @return
     * @throws Exception
     */
    public int exec(String shell) throws Exception {
        int ret = -1;
        String result = "";
        try {
            if (login()) {
                Session session = conn.openSession();
                session.execCommand(shell);
                InputStream in = session.getStdout();
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                // ret 得到脚本运行成功与否的标志 ：0－成功 非0－失败
                ret = session.getExitStatus();
//                String s = processStdout(in, "UTF-8");
//                System.out.println(s);
                if (ret == 0){
                    List<String> list = this.processStdoutToList(in, "UTF-8");
                    // 将list转为model
                    ServerMonitorInfo serverMonitorInfo = new ServerMonitorInfo();
                    if (list.size() > 12){
                        serverMonitorInfo.setIp(list.get(0));
                        serverMonitorInfo.setCpu(Integer.valueOf(list.get(1)));
                        serverMonitorInfo.setCpuUsedRate(list.get(2));
                        serverMonitorInfo.setHardAll(list.get(3));
                        serverMonitorInfo.setHardUsed(list.get(4));
                        serverMonitorInfo.setHardUsedRate(list.get(5));
                        serverMonitorInfo.setMemAll(list.get(6));
                        serverMonitorInfo.setMemUsed(list.get(7));
                        serverMonitorInfo.setMemUsedRate(list.get(8));
                        serverMonitorInfo.setSwapAll(list.get(9));
                        serverMonitorInfo.setSwapUsed(list.get(10));
                        serverMonitorInfo.setSwapUsedRate(list.get(11));
                        System.out.println(serverMonitorInfo.toString());
                    }

                }else {
                    System.out.println("执行失败");
                }
                
            } else {
                throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return ret;
    }

    /**
     * 解析流获取字符串信息
     *
     * @param in 输入流对象
     * @param charset 字符集
     * @return
     */
    public String processStdout(InputStream in, String charset) {
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        try {
            while (in.read(buf) != -1) {
                sb.append(new String(buf, charset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 解析流获取字符串信息
     *
     * @param in 输入流对象
     * @param charset 字符集
     * @return
     */
    public List<String> processStdoutToList(InputStream in, String charset) {
        List<String> list = new LinkedList<String>();
        byte[] buf = new byte[1024];
        try {
            while (in.read(buf) != -1) {
                list.addAll(Arrays.asList(new String(buf, charset).split("\\n")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            RemoteShellExecutor executor = new RemoteShellExecutor("47.102.98.18", "root", "Zj123456");
            executor.exec("bash /usr/test/monitor3.sh");
            int a= 1073741824;
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}

