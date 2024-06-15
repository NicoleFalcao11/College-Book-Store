package com.bookSB.Books.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//For Intent Flow UPI Payments
@Entity
@Table(name = "Transactions")
public class Transactions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private Long OrderId;
	
	@Column(name = "UPI_Id")
	private String UPI_Id;
	
	@Column(name = "BookId")
	private Long BookId;
	
	@Column(name = "BuyerId")
	private Long BuyerId;
	
	@Column(name = "BuyerUPI")
	private String BuyerUPI;
	
	@Column(name = "SellerId")
	private Long SellerId;
	
	@Column(name = "SellerUPI")
	private String SellerUPI;
	
	@Column(name = "completed")
	private Boolean completed;
	
	public Transactions() {
		
	}

	public Transactions(Long orderId, String uPI_Id, Long BookId ,Long buyerId, String buyerUPI, Long sellerId, String sellerUPI , Boolean completed) {
		super();
		OrderId = orderId;
		UPI_Id = uPI_Id;
		this.BookId = BookId;
		BuyerId = buyerId;
		BuyerUPI = buyerUPI;
		SellerId = sellerId;
		SellerUPI = sellerUPI;
		this.completed = completed;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public String getUPI_Id() {
		return UPI_Id;
	}

	public void setUPI_Id(String uPI_Id) {
		UPI_Id = uPI_Id;
	}
	
	public Long getBookId() {
		return BookId;
	}

	public void setBookId(Long bookId) {
		this.BookId = bookId;
	}

	public Long getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(Long buyerId) {
		BuyerId = buyerId;
	}

	public String getBuyerUPI() {
		return BuyerUPI;
	}

	public void setBuyerUPI(String buyerUPI) {
		BuyerUPI = buyerUPI;
	}

	public Long getSellerId() {
		return SellerId;
	}

	public void setSellerId(Long sellerId) {
		SellerId = sellerId;
	}

	public String getSellerUPI() {
		return SellerUPI;
	}

	public void setSellerUPI(String sellerUPI) {
		SellerUPI = sellerUPI;
	}
	
	public Boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean c) {
		this.completed = c;
	}

	@Override
	public String toString() {
		return "Transactions [OrderId=" + OrderId + ", UPI_Id=" + UPI_Id + ", BookId=" + BookId + " ,BuyerId=" + BuyerId + ", BuyerUPI="
				+ BuyerUPI + ", SellerId=" + SellerId + ", SellerUPI=" + SellerUPI + "  , Completed=" + completed + "]";
	}
	
}
