package com.bookSB.Books.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookSB.Books.Entity.Cart;

public interface CartRepo extends JpaRepository <Cart , Long>{
	
	@Query("SELECT c.bookid FROM Cart c WHERE c.rollno = :rollno")
    List<Long> findBookIdByrollno(@Param("rollno") Long rollno);
	
//	@Query("DELETE FROM Cart c WHERE c.rollno = :rollno AND c.bookid = :bookid")
//	void deleteByRollnoAndBkid(@Param("rollno") Long rollno, @Param("bookid") Long bookid);
	@Query("SELECT c.cart_id FROM Cart c WHERE c.rollno = :rollno AND c.bookid = :bookid")
	List<Long> deleteByRollnoAndBkid(@Param("rollno") Long rollno, @Param("bookid") Long bookid);
	
}
