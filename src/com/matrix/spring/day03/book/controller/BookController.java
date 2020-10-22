package com.matrix.spring.day03.book.controller;

import com.matrix.spring.day03.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
