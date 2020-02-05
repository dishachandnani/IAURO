package com.info.sh;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		System.out.println("=====Welcome to menu driven program====");
		System.out.println("1.) Please enter 1 to write data in text file");
		System.out.println("2.) Please enter 2 to write data in CSV file");
		System.out.println("3.) Please enter 3 to terminate the program");
		try (Scanner scan = new Scanner(System.in)) {
			try (BookDao dao = new BookDao()) {
				dao.open();
				List<Book> list = dao.getBooks(BookConstant.C);
				while (true) {
					int choice = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("=====Start Writing data in text File====");
						if (!list.isEmpty())
							FileWriterHelper.writeInTextFile(list);
						break;
					case 2:
						System.out.println("=====Start Writing data in CSV File=====");
						if (!list.isEmpty())
							FileWriterHelper.writeInCSVFile(list);
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("Please enter correct choice");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in main class : " + e);
		}
	}
}
