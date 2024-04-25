package com.bookSB.Books.Service;

import java.util.List;

import com.bookSB.Books.DTO.SignupRequest;
import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Entity.Student;

public interface StudentService {
	
	String getNameById(Long RollNo);
	String getMobnoById(Long RollNo);
	String getEmailById(Long RollNo);
	
	Student createStudent(SignupRequest s);
	void verify(String email,String otp);
	SignupRequest updateStudent(SignupRequest s, Long sid);
	SignupRequest getStudentById(Long sid);
	String DeleteStudentById(Long sid);
	
	List<Book> getBookBySellerId(Long sid);
    List <Book> getBookByBuyerId(Long bid);
    List<Book> getBooksSold(Long sid);
    List<Book> getRecentBooks();
    
    List<Book> getCartItems(Long rollno);
    void addCartItem(Long rollno,Long bkid);
    String deleteCartItem(Long rollno , Long bkid);
    
    String notifySeller(String email , String bkname , SignupRequest buyer);
}
