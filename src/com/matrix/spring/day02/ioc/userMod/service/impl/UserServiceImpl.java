package com.matrix.spring.day02.ioc.userMod.service.impl;

import com.matrix.spring.day02.ioc.userMod.dao.UserDao;
import com.matrix.spring.day02.ioc.userMod.dao.impl.UserDaoImpl;
import com.matrix.spring.day02.ioc.userMod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDaoMyBatisImpl") // 有多个实现类的时候, 指定特定的bean 其中value是bean的id 该注解是和@Autowired 是一起使用的
    private UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }

    @Override
    public void addUser() {
        userDao.addUser();
    }
}
