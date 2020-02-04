package com.info.sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class BookDao implements AutoCloseable {

	private Connection connection;
	
	public static final String QUERY_BY_SUBJECT="select * FROM BOOKS WHERE SUBJECT=?";
	
	public void open() throws Exception {
		connection = DriverManager.getConnection(DbUtil.DB_URL, DbUtil.DB_USER, DbUtil.DB_PASS);
	}
	
	@Override
	public void close() throws Exception {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			System.out.println("Exception while closing DB connection !!!!!"+e.getMessage());

		}

	}
	
	public List<Book> getBooks(String subject) throws Exception {
		List<Book> list = new ArrayList<Book>();		
		try (PreparedStatement stmt = connection.prepareStatement(QUERY_BY_SUBJECT)) {
			stmt.setString(1, subject);
			try (ResultSet resultSet = stmt.executeQuery()) {
				while (resultSet.next()) {
					Book book = new Book();
					book.setId(resultSet.getInt(BookConstant.ID));
					book.setName(resultSet.getString(BookConstant.NAME));
					book.setAuthor(resultSet.getString(BookConstant.AUTHOR));
					book.setSubject(resultSet.getString(BookConstant.SUBJECT));
					book.setPrice(resultSet.getDouble(BookConstant.PRICE));
					list.add(book);
				}
			}
		}
		return list;
	}


}
