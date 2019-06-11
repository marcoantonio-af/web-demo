package com.example.demo.data;

import java.sql.*;
import java.util.Random;
import java.util.UUID;

public class ConSql {
    /**
     * 批量新增
     * @throws Exception
     */
    public static void batchInsert() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
        //获取连接
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        //数据库操作对象
        Statement statement = conn.createStatement();
        System.out.println("连接成功");
       //执行sql
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String sql =
                    "insert into test (name,sex)" +
                     "VALUES ('" + UUID.randomUUID().toString() + "', '"+String.valueOf(new Random().nextInt()) + "') ";
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }
        conn.commit();
        conn.close();
        Long end = System.currentTimeMillis();
        System.out.println("单条执行1000条Insert操作，共耗时：" + (end - start) / 1000f + "秒！");
    }

    /**
     * 查询数据
     * @throws Exception
     */
    public static void selectData() throws Exception{
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("1");
        String url = "jdbc:mysql://localhost:3306/bookdb?characterEncoding=UTF-8";
        //获取连接
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        //数据库操作对象
        Statement statement = conn.createStatement();
        System.out.println("连接成功");
        //执行sql
        ResultSet resultSet = statement.executeQuery("select *  from books");
        while (resultSet.next()) {
            System.out.println("结果" + resultSet.getString(2));
        }
        resultSet.close();
        conn.close();
    }

    /**
     * 事务及回滚
     * @throws Exception
     */

    public static void transaction() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
        //获取连接
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        //数据库操作对象
        Statement statement = conn.createStatement();
        System.out.println("连接成功");
        //执行sql
        try {
            conn.setAutoCommit(false);
            String insert = "insert into test(name, sex) values('1', '1')";
            Statement stmt = conn.createStatement();
            stmt.execute(insert);
            String insert2 = "insert into test(id, name, sex) values(2, '2', '2')";
            stmt.execute(insert2);
            String insert3 = "insert into test(name, sex) values('3', '3')";
            stmt.execute(insert3);
            conn.commit();
        }catch (Exception e){
            System.out.println("发生异常");
            conn.rollback();
        }
        conn.close();
    }

    public static void main(String[] args) throws Exception {
      //  ConSql.selectData();
        ConSql.transaction();
    }

}
