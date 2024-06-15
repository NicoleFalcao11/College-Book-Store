package com.bookSB.Books.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//For RazorPlay
@Entity
@Table(name = "Buyer_Seller")
public class Buyer_Seller {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tran_Id")
	private Long tran_Id;
	
	@Column(name = "payment_id")
	private String payment_id;
	
	@Column(name = "order_id")
	private String order_id;
	
	@Column(name = "bookId")
	private Long bookId;
	
	@Column(name = "sellId")
	private Long sellId;
	
	@Column(name = "buyId")
	private Long buyId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private double amount;
	
	public Buyer_Seller(){
		
	}

	public Buyer_Seller(Long tran_Id, String payment_id, String order_id, Long bookId, Long sellId, Long buyId, Date date,
			double amount) {
		super();
		this.tran_Id = tran_Id;
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.bookId = bookId;
		this.sellId = sellId;
		this.buyId = buyId;
		this.date = date;
		this.amount = amount;
	}

	public Long getTran_Id() {
		return tran_Id;
	}

	public void setTran_Id(Long tran_Id) {
		this.tran_Id = tran_Id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getSellId() {
		return sellId;
	}

	public void setSellId(Long sellId) {
		this.sellId = sellId;
	}

	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Buyer_Seller [tran_Id=" + tran_Id + ", payment_id=" + payment_id + ", order_id=" + order_id
				+ ", bookId=" + bookId + ", sellId=" + sellId + ", buyId=" + buyId + ", date=" + date + ", amount="
				+ amount + "]";
	}

	
}
