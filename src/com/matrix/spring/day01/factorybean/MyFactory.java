package com.matrix.spring.day01.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Car> {


    @Override
    public Car getObject() throws Exception {
        Car car = new Car(); // 工厂创建的一个对象
        car.setBrand("Mustang");
        car.setPrice(30.0);
        return car; // 通过工厂获得的对象
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
