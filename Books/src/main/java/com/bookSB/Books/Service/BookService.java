package com.bookSB.Books.Service;

import java.util.List;

import com.bookSB.Books.Entity.Book;

public interface BookService {
	
	List<Book> getBooks();
	Book getBookById (Long Id );
	Book AddBook(Book Bk);
	Book UpdateBook(Book Bk,Long Id);
	String DeleteAll();
	String DeleteById(Long Id);

}
