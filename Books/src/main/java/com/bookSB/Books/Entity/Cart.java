package com.bookSB.Books.Entity;

import java.util.List;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cart_id;
	
	@Column(name = "rollno")
	private Long rollno;
	
	@Column(name = "bookid")
	private Long bookid;
	
	public Cart() {
		
	}

	public Cart(Long cart_id, Long rollno, Long bookid) {
		super();
		this.cart_id = cart_id;
		this.rollno = rollno;
		this.bookid = bookid;
	}

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", rollno=" + rollno + ", bookid=" + bookid + "]";
	}
	
}
