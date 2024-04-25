package com.bookSB.Books.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookSB.Books.Entity.Buyer_Seller;

public interface BuySellRepository extends JpaRepository <Buyer_Seller , Long> {
	
	@Query("SELECT bs.bookId FROM Buyer_Seller bs WHERE bs.buyId = :buyId")
	List<Long> findBookIdBybuyId(@Param("buyId")Long buyId);
	
	@Query("SELECT bs.bookId FROM Buyer_Seller bs WHERE bs.sellId = :sellId")
    List<Long> findBooksSoldIdByseller(@Param("sellId") Long sellId);
	
}
