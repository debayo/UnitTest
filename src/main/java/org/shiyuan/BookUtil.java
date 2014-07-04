package org.shiyuan;

import java.util.ArrayList;
import java.util.List;

public class BookUtil {
	public BookUtil() {
	}

	public int add(int a, int b) {
		return a + b;
	}

	public Book getBook(int id) {
		return new Book("book", id);
	}

	private List<Book> getBookList(int size) {
		return new ArrayList<Book>();
	}

	public static int getSize() {
		return 42;
	}
}
