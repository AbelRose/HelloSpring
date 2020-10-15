package com.matrix.spring.day02.ioc.userMod.service.impl;

import com.matrix.spring.day02.ioc.userMod.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }
}
