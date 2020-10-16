package com.matrix.spring.day02.ioc.userMod;

import com.matrix.spring.day02.ioc.userMod.controller.UserController;
import com.matrix.spring.day02.ioc.userMod.dao.UserDao;
import com.matrix.spring.day02.ioc.userMod.dao.impl.UserDaoImpl;
import com.matrix.spring.day02.ioc.userMod.service.UserService;
import com.matrix.spring.day02.ioc.userMod.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");
        UserController uc = ac.getBean("userController", UserController.class);
        System.out.println(uc);
		UserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(us);
		UserDao ud = ac.getBean("userDaoImpl", UserDaoImpl.class);
		System.out.println(ud);
		uc.addUser();

    }
}
