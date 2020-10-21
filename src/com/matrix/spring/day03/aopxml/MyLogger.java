package com.matrix.spring.day03.aopxml;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class MyLogger {

    public void before() {
        System.out.println("前置通知...");
    }
}
