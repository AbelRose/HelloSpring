package com.matrix.spring.day03.book.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
