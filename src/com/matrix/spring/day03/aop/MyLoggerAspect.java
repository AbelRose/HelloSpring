package com.matrix.spring.day03.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect // 用来标注当前类为切面
@Order(1) // 设置优先级 值越小优先级越高，默认值为int的最大值
public class MyLoggerAspect {

    @Pointcut(value = "execution(* com.matrix.spring.day03.aop.*(..))")
    public void test() {
        // 重用切入点定义

    }


    /**
     * 用于存储横切关注点的类 即切面
     * @author matrix
     */

    /**
     * @Before:将方法指定为前置通知
     * 必须设置value，其值为切入点表达式
     * 前置通知：作用于方法执行之前
     * @Before(value="execution(* com.atguigu.spring.aop.*.*(..))")
     * 第一个*代表任意的访问修饰符和返回值类型
     * 第二个*代表任意类
     * 第三个*代表类中任意方法
     * ..代表任意的参数列表
     */

//    @Before(value = "execution(public int com.matrix.spring.day03.aop.impl.CalImpl.add(int, int))")
    @Before(value = "test()") // public int 对应一个 * || CalImpl 对应一个 * || add 对用一个* || int , int 对应两个..
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
//        System.out.println(Arrays.toString(args));
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName: " + methodName + ", args: " + Arrays.toString(args));
        System.out.println("方法执行之前");
    }

    /**
     * @After:将方法标注为后置通知
     * 后置通知：作用于方法的finally语句块，即不管有没有异常都会执行
     */
    @After(value = "execution(* com.matrix.spring.day03.aop.*.*(..))")
    public void afterMethod() {
        System.out.println("后置通知");
    }

    /**
     * @AfterReturning:将方法标注为返回通知
     * 返回通知：作用于方法执行之后
     * 可通过returning设置接收方法返回值的变量名
     * 要想在方法中使用，必须在方法的形参中设置和变量名相同的参数名的参数
     */
    @AfterReturning(value = "execution(* com.matrix.spring.day03.aop.*.*(..))", returning = "result")
    public void afterReturningMtehod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName: " + methodName + ", result: " + result);
//        System.out.println("返回通知");
    }

    @AfterThrowing(value = "execution(* com.matrix.spring.day03.aop.*.*(..))" , throwing = "ex")
    public void afterThrowingMethod(Exception ex) {
        System.out.println("有异常了...: " + ex);
    }

    /*@Around(value="execution(* com.atguigu.spring.aop.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {

		Object result = null;

		try {
			//前置通知
			System.out.println("前置通知");
			result = joinPoint.proceed();//执行方法
			//返回通知
			System.out.println("返回通知");
			return result;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//异常通知
			System.out.println("异常通知");
		} finally {
			//后置通知
			System.out.println("后置通知");
		}

		return -1;
	}*/

}
