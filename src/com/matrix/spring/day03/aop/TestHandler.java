package com.matrix.spring.day03.aop;

import org.springframework.stereotype.Component;

@Component
public class TestHandler {
    // 通过继承Object和cglib来实现

    public void test() {
        System.out.println("测试切入点表达式");
    }
}
