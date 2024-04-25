package com.bookSB.Books.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookSB.Books.Entity.Book;


public interface BookRepository extends JpaRepository <Book , Long>{
	@Query("SELECT b.Id FROM Book b WHERE b.SID = :SID AND b.avail = true")
    List<Long> findBookIdBysellId(@Param("SID") Long SID);
	
	@Query("SELECT b.Id FROM Book b WHERE b.avail=true")
	List<Long> findAllUnSold();
	
	@Query("UPDATE Book b SET b.avail = false WHERE b.id = :id")
	void setAvailToFalse(@Param("id") Long id);
	
	@Query("SELECT b FROM Book b ORDER BY b.Id DESC LIMIT 4")
    List<Book> findRecentBooks();
 }
