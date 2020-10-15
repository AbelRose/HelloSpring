package com.matrix.spring.day02.ioc.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args)  throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource.xml");
        DruidDataSource bean = ac.getBean("datasource", DruidDataSource.class); // 这个bean 在com.alibaba.druid.pool 中
        System.out.println(bean.getConnection());

    }

}
