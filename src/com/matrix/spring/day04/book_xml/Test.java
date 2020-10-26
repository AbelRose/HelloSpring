package com.matrix.spring.day04.book_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.matrix.spring.day04.book_xml.controller.BookController;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("book_xml.xml");
		BookController controller = ac.getBean("bookController", BookController.class);
		controller.buyBook();
		//controller.checkOut();
		
	}
	
}