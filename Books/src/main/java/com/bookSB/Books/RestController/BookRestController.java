package com.bookSB.Books.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Service.BookService;
import com.bookSB.Books.Service.StudentService;

@RestController
@RequestMapping("/bookstore")
public class BookRestController {
	
	@Autowired
	private BookService Bk;
	

    @Autowired
   private StudentService serve;

	// GET
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Bk.getBooks();
	}
	
	@GetMapping("/books/{Id}")
	public Book getBooksbyId(@PathVariable Long Id) {
		
		Book book =  Bk.getBookById(Id);
		Long num = book.getSID();
		String name = serve.getNameById(num);//GetByRollNo
		String mobno = serve.getMobnoById(num);
		String email = serve.getEmailById(num);
		
		book.setSellId(num);
		book.setName(name);
		book.setMobno(mobno);
		book.setEmail(email);
		return book;
}
	
	//POST
	@PostMapping("/books")
	public Book AddBook(@RequestBody Book bks) {
		return Bk.AddBook(bks);
	}
	
	//PUT
	
	@PutMapping("/books/{Id}")
	public Book UpdateBook(@RequestBody Book bks ,@PathVariable Long Id) {
		return Bk.UpdateBook(bks,Id);
	}
	
	
	//DELETE
	
	@DeleteMapping("/books/{Id}")
	public ResponseEntity<HttpStatus> deleteBooks(@PathVariable Long Id) {
		try {
			Bk.DeleteById(Id);
			return new ResponseEntity<> (HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
