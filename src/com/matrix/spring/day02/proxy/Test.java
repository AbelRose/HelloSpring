package com.matrix.spring.day02.proxy;

import com.matrix.spring.day02.proxy.impl.CalImpl;

public class Test {

    public static void main(String[] args) {
//        // 自己调用的
//        CalImpl cal = new CalImpl();
//        int res = cal.add(1, 1);
//        System.out.println(res);

        // 通过动态代理 执行
        ProxyUtil proxyUtil = new ProxyUtil(new CalImpl());
        Cal cal = (Cal) proxyUtil.getProxy(); // 生成代理对象后 要强转成接口 而不是目标类
        int add = cal.add(1, 1);
        System.out.println(add);
    }
}
