package com.matrix.spring.day02.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 后置处理器
public class AfterHandler implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Person person = (Person) bean;
        if (person.getSex().equals("男")) {
            person.setName("夏洛克");
        }else {
            person.setName("华生");
        }
        return person;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean; // 注意这个地方要返回bean
    }
}
