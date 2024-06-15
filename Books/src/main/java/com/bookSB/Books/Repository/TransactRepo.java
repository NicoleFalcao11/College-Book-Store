package com.bookSB.Books.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookSB.Books.Entity.Transactions;

public interface TransactRepo extends JpaRepository <Transactions , Long> {
	
	//Books Bought
	@Query("SELECT t.BookId FROM Transactions t WHERE t.BuyerId = :buyId")
	List<Long> findBookIdBybuyId(@Param("buyId")Long buyId);
	
	
	//Books Sold
	@Query("SELECT t.BookId FROM Transactions t WHERE t.SellerId = :sellId")
    List<Long> findBooksSoldIdByseller(@Param("sellId") Long sellId);
	
}
