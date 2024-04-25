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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookSB.Books.DTO.SignupRequest;
import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Repository.BookRepository;
import com.bookSB.Books.Service.BookService;
import com.bookSB.Books.Service.StudentService;


@RestController
@RequestMapping("/student")
public class Studentcontroller{
	
	
   @Autowired
   private StudentService s;
   
   @Autowired
   private BookService Bk;
   
   @Autowired
   private BookRepository br;

	@GetMapping("/{Id}")
	public SignupRequest getStudentbyId(@PathVariable Long Id) {
		
		SignupRequest stu =  s.getStudentById(Id);
		return stu;
}
	
	//PUT
	@PutMapping("/{Id}")
	public SignupRequest UpdateStudent(@RequestBody SignupRequest su ,@PathVariable Long Id) {
		return s.updateStudent(su,Id);
	}
	
	//GetAllBooksSoldByStudent
	@GetMapping("/sold/{Id}")
	public List<Book> getBooksSold(@PathVariable Long Id) {
		return s.getBookBySellerId(Id);
    }
	
	//GetAllBooksBoughtByStudent
	@GetMapping("/bought/{Id}")
	public List<Book> getBooksBought(@PathVariable Long Id) {
		return s.getBookByBuyerId(Id);
	}
	
	@GetMapping("/books/recent")
	public List<Book> getRecent(){
		return s.getRecentBooks();
	}
		

	//DELETE
	@DeleteMapping("/{Id}")
	public ResponseEntity<HttpStatus> deleteBooks(@PathVariable Long Id) {
		try {
			s.DeleteStudentById(Id);
			return new ResponseEntity<> (HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//For API Response See Video 12 
		
	}
	
	//CART
	@GetMapping("/getCart/{rollno}")
	public List<Book> getCart(@PathVariable Long rollno){
		return s.getCartItems(rollno);
	}
	
	@GetMapping("/addtocart/{rollno}/{bookid}")
	public String addCart(@PathVariable Long rollno , @PathVariable Long bookid) {
		s.addCartItem(rollno, bookid);
		return "Item Added Successfully";
	}
	
	@DeleteMapping("/deletecart/{rollno}/{bookid}")
	public String delCart(@PathVariable Long rollno , @PathVariable Long bookid) {
		return s.deleteCartItem(rollno, bookid);
		
	}
	
	@PostMapping("/notify/{rollno}/{id}/{email}")
	public String notify(@PathVariable Long rollno ,@PathVariable Long id,@PathVariable String email) {
		System.out.println("\nIn Controller "+email);
		SignupRequest buy = s.getStudentById(rollno);
        Book b = Bk.getBookById(id);
        br.setAvailToFalse(id);
        return s.notifySeller(email,b.getBkname() , buy );
	}
	
}
