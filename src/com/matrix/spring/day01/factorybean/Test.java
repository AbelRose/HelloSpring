package com.matrix.spring.day01.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("factory-bean.xml");
        Object bean = ac.getBean("factory"); // 根据bean id得到的bean
        System.out.println(bean); // 得到的是 MyFactory 中 getObject()所返回的对象(又他本身变成了由他本身创建的对象) 这便是工厂模式
    }
}
