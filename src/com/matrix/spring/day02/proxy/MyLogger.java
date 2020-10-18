package com.matrix.spring.day02.proxy;

public class MyLogger {

    /**
     * 这个类相当于切面(Aspect)
     * @param methName
     * @param args
     */

    public static void before(String methName, String args) {
        // 相当于前置通知
        System.out.println("method:" + methName + "," + "arguments:" + args);
    }

    public static void after(String methName, Object result) {
        // 相当于后置通知
        System.out.println("method:" + methName + "," + "arguments:" + result);
    }

    public static void throwIng() {
        System.out.println("出现异常...");
    }

}
