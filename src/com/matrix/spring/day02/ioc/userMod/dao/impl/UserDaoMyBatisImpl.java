package com.matrix.spring.day02.ioc.userMod.dao.impl;

import com.matrix.spring.day02.ioc.userMod.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMyBatisImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("UserDaoMyBatisImpl: 添加成功");
    }

}
