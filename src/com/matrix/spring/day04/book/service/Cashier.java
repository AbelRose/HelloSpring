package com.matrix.spring.day04.book.service;

import java.util.List;

public interface Cashier {

	void checkOut(String uid, List<String> bids);
	
}
