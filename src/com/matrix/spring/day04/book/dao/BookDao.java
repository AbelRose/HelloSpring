package com.matrix.spring.day04.book.dao;

public interface BookDao {

	Integer selectPrice(String bid);
	
	void updateSt(String bid);
	
	void updateBalance(String uid, Integer price);
	
}
