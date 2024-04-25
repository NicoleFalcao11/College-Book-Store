package com.bookSB.Books.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Entity.Buyer_Seller;
import com.bookSB.Books.Repository.BookRepository;
import com.bookSB.Books.Repository.BuySellRepository;

@Service
public class BookServiceImpl implements BookService {
	
   @Autowired	
   private BookRepository bkrepo;
   
   @Autowired
   private BuySellRepository bs;
	
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Long> ids =  bkrepo.findAllUnSold();
		return bkrepo.findAllById(ids);
	}

	@Override
	public Book getBookById(Long Id) {
		// TODO Auto-generated method stub
		Optional<Book> optionalBook = bkrepo.findById(Id);
		Book book = optionalBook.get();
		return book;
	}

	@Override
	public Book AddBook(Book Bk) {
		// TODO Auto-generated method stub you can pass session roll no of user as request param and set it if needed
		Book saved =  bkrepo.save(Bk);
		Long bId = saved.getId();
		Long sellId = saved.getSID();
		Buyer_Seller buy = new Buyer_Seller();
		buy.setBookId(bId);
		buy.setSellId(sellId);
		bs.save(buy);
		return Bk;
	}

	@Override
	public Book UpdateBook(Book Bk , Long Id) {
		// TODO Auto-generated method stub
		Optional<Book> optionalBook = bkrepo.findById(Id);
		Book book = optionalBook.get();
		book.setBkimg(Bk.getBkimg());
		book.setBkname(Bk.getBkname());
		book.setCondi(Bk.getCondi());
		book.setAvail(Bk.getAvail());
		book.setSID(Bk.getSID());
		book.setPrice(Bk.getPrice());
		bkrepo.save(book);
		return book;
	}

	@Override
	public String DeleteAll() {
		// TODO Auto-generated method stub
		 bkrepo.deleteAll();
		 return "All Books Have Been Deleted";
	}

	@Override
	public String DeleteById(Long Id) {
		// TODO Auto-generated method stub
		bkrepo.deleteById(Id);
		return "Book "+Id+" Has Been Deleted";
		
	}

	

}
