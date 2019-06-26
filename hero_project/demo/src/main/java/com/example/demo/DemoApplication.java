package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("com.example.demo")
@MapperScan("com.example.demo.mapper")
@EnableAsync
public class DemoApplication {

	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//	/**
//	 * 查看用了什么数据库连接池
//	 */
//	public void run(String... args) throws Exception {
//		System.out.println("DATASOURCE = " + dataSource);
//	}
}
