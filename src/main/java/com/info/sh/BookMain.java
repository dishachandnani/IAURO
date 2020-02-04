package com.info.sh;

import java.util.List;

public class BookMain {

	public static void main(String[] args) {
		try (BookDao dao = new BookDao()) {
			dao.open();
			List<Book> list = dao.getBooks(BookConstant.C);
			for (Book book : list) {
				System.out.println(book);
			}
		} catch (Exception e) {
			System.out.println("Exception in main class : "+e);
		}
	}

}
