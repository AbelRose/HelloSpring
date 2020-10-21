package com.matrix.spring.day03.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class TestAspect {

    @Before(value = "execution(* com.matrix.spring.day03.aop.*(..))")
    public void before() {
        System.out.println("TestAspect的前置通知...");
    }

}
