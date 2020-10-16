package com.matrix.spring.day02.proxy.impl;

import com.matrix.spring.day02.proxy.Cal;

public class CalImpl implements Cal {
    @Override
    public int add(int i, int j) {
        int res = i + j;
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        return res;
    }
}
