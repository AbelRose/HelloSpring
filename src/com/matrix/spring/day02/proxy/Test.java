package com.matrix.spring.day02.proxy;

import com.matrix.spring.day02.proxy.impl.CalImpl;

public class Test {

    public static void main(String[] args) {
        CalImpl cal = new CalImpl();
        int res = cal.add(1, 1);
        System.out.println(res);
    }
}
