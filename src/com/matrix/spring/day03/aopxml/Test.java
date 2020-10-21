package com.matrix.spring.day03.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");
        Cal cal = ac.getBean("calImpl", Cal.class);
        int res = cal.add(1, 1);
        System.out.println(res);
    }
}
