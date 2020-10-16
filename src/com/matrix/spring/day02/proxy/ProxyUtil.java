package com.matrix.spring.day02.proxy;

import com.matrix.spring.day02.proxy.impl.CalImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    /**
     * 代理对象可以为任何目标对象 进行代理
     * 原则是 保证目标对象一致性
     */

    private CalImpl calImpl; // 创建目标对象

    public Object getProxy() {

        ClassLoader loader = this.getClass().getClassLoader(); // 类加载器

        Class[] interfaces = calImpl.getClass().getInterfaces(); // 目标对象要实现的功能

        return Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {// 使用匿名内部创建对象
                return method.invoke(calImpl, args); // 用目标对象invoke 保证了结果一致性 args 是目标的args
            }
        }); //通过JDK内部进行代理的叫做JDK动态代理 (必须有接口)
    }
}
