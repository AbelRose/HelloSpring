package com.matrix.spring.day03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        Cal cal = ac.getBean("calImpl", Cal.class);
        int add = cal.add(1, 2);
        System.out.println(add);

    }
}
