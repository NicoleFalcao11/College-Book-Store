package com.bookSB.Books.DTO;

import java.util.Date;

public class TransactDTO {
	
	private Long payment_id;
	private Long order_id;
	private Long bookId;
	private Long sellId;
	private Long buyId;
	private Date date;
	private double amount;
	
	public TransactDTO() {
		
	}

	public TransactDTO(Long payment_id, Long order_id, Long bookId, Long sellId, Long buyId, Date date, double amount) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.bookId = bookId;
		this.sellId = sellId;
		this.buyId = buyId;
		this.date = date;
		this.amount = amount;
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
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
		return "TransactDTO [payment_id=" + payment_id + ", order_id=" + order_id + ", bookId=" + bookId + ", sellId="
				+ sellId + ", buyId=" + buyId + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
}
