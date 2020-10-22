package com.matrix.spring.day03.book.service.impl;

import com.matrix.spring.day03.book.dao.BookDao;
import com.matrix.spring.day03.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    @Autowired
    private BookDao bookDao;

}
