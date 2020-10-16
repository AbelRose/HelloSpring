package com.matrix.spring.day02.ioc.userMod.dao.impl;

import com.matrix.spring.day02.ioc.userMod.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl");
    }

    @Override
    public void addUser() {
        System.out.println("添加成功");
    }
}
