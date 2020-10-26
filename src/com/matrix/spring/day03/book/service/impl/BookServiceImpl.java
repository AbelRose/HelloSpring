package com.matrix.spring.day03.book.service.impl;

import com.matrix.spring.day03.book.dao.BookDao;
import com.matrix.spring.day03.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(String bid, String uid) {
        Integer price = bookDao.selectPrice(bid);
        bookDao.updateSt(bid);
        bookDao.updateBalance(uid, price);
    }
}
