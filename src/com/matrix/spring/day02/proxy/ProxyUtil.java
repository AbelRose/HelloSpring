package com.matrix.spring.day02.proxy;

import com.matrix.spring.day02.proxy.impl.CalImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {

    /**
     * 代理对象可以为任何目标对象 进行代理
     * 原则是 保证目标对象一致性
     *
     * AOP是基于JDK动态代理的
     *
     */

    private CalImpl calImpl; // 创建目标对象  JDK动态代理必须有接口  CGLIB是必须有继承

    public ProxyUtil(CalImpl calImpl) {
        this.calImpl = calImpl;
    }

    public Object getProxy() { // 生成代理对象
        //获取当前类的类加载器，用来加载代理对象所属类
        ClassLoader loader = this.getClass().getClassLoader(); // 类加载器 (通过这个类加载)
        //获取目标对象实现的所有接口的Class，代理类回合目标类实现相同的接口，最终通过代理对象实现功能
        Class[] interfaces = calImpl.getClass().getInterfaces(); // 目标对象要实现的功能 (即得到所有的接口)

        return Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            //代理对象实现功能的方式
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {// 使用匿名内部创建对象 invoke代表执行的意思
                try {
                    //                System.out.println("动态代理前");
                    MyLogger.before("方法执行前: " + method.getName(), Arrays.toString(args));
                    Object result = method.invoke(calImpl, args); // 用目标对象的方法 保证了结果一致性 args 是目标的args
//                System.out.println("结果是: " + result);
//                System.out.println("动态代理后");
                    MyLogger.after("方法执行后: " + method.getName(), result);
                    return result;
                }catch (Exception e) {
                    MyLogger.throwIng();
                    e.printStackTrace();
                } finally {
                    System.out.println("finally: 无论怎样都会执行");
                }
                return null;
            }
        }); //通过JDK内部进行代理的叫做JDK动态代理 (必须有接口)
    }
}
