package com.matrix.spring.day02.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
        Student student1 = ac.getBean("student", Student.class); // 常用的获取Bean的方式，通过bean的id 和 类型
        Student student2 = ac.getBean("student", Student.class); // scope="singleton" 单例模式创建出来的都一样 内存地址是一样的
        System.out.println(student1);
        System.out.println(student1.equals(student2));
    }
}
