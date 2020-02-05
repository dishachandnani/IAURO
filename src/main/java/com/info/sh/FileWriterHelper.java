package com.info.sh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.opencsv.CSVWriter;

public class FileWriterHelper {
	public static File file = null;

	public static void writeInCSVFile(List<Book> list) {
		file = new File(BookConstant.CSV_FILE_NAME);
		try (FileWriter outputfile = new FileWriter(file)) {
			try (CSVWriter writer = new CSVWriter(outputfile)) {
				String[] header = { BookConstant.ID, BookConstant.NAME, BookConstant.AUTHOR, BookConstant.SUBJECT,
						BookConstant.PRICE };
				writer.writeNext(header);
				for (Book book : list) {
					String[] record = { String.valueOf(book.getId()), book.getName(), book.getAuthor(),
							book.getSubject(), String.valueOf(book.getPrice()) };
					writer.writeNext(record);
					System.out.printf("%d  %-20s  %-15s  %s  %.2f\n", book.getId(), book.getName(),
							book.getAuthor(), book.getSubject(), book.getPrice());
				}
			}
			System.out.println("=====CSV File has generated successfully======");
		} catch (IOException e) {
			System.out.println("Error in while writeInCSVFile  !!!!!" + e);
		}
	}

	public static void writeInTextFile(List<Book> list) {
		file = new File(BookConstant.TXT_FILE_NAME);
		try (OutputStream outputStream = (OutputStream) new FileOutputStream(file)) {
			try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, BookConstant.ENCODING)) {
				try (BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
					for (Book book : list) {
						if (book != null) {
							bufferedWriter.write(String.format("%d  %-20s  %-15s  %s  %.2f\n", book.getId(),
									book.getName(), book.getAuthor(), book.getSubject(), book.getPrice()));
							System.out.printf("%d  %-20s  %-15s  %s  %.2f\n", book.getId(), book.getName(),
									book.getAuthor(), book.getSubject(), book.getPrice());
						}
					}
				}
			}
			System.out.println("=====TSV File has generated successfully======");
		} catch (IOException e) {
			System.out.println("Exception in writeInTextFile method : " + e);
		}

	}

}
