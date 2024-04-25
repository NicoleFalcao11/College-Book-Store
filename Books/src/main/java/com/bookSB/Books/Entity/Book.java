package com.bookSB.Books.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Book")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;
	
	@Column(name = "bkname")
	private String bkname;
	
	@Column(name = "bkimg" ,length = 450)
	private String bkimg;
	
	@Column(name = "Condi")
	private String Condi;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "avail")
	private Boolean avail;
	
	@Column(name = "Semester")
	private int Semester;
	
	@Column(name = "Subject")
	private String Subject;
	
	@Column(name = "SID")
	private Long SID;
	
	//Seller Details

	@ManyToOne
    @JoinColumn(name = "RollNo")
    @JsonIgnore 
    private Student student;
	
	 @Transient
	 private Long sellId;

	 @Transient
	 private String Name;

	 @Transient
	 private String Mobno;
	 
	 @Transient
	 private String email;

	public Book(long id, String bkname, String bkimg, String condi, double price, Boolean avail, int semester,
			String subject, Long sID, Student student, Long seller ,String name, String mobno, String email) {
		super();
		Id = id;
		this.bkname = bkname;
		this.bkimg = bkimg;
		Condi = condi;
		this.price = price;
		this.avail = avail;
		Semester = semester;
		Subject = subject;
		SID = sID;
		this.student = student;
		sellId = seller;
		Name = name;
		Mobno = mobno;
		this.email = email;
	}
	 
    public Book() {
    	
    }

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getBkname() {
		return bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getBkimg() {
		return bkimg;
	}

	public void setBkimg(String bkimg) {
		this.bkimg = bkimg;
	}

	public String getCondi() {
		return Condi;
	}

	public void setCondi(String condi) {
		Condi = condi;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Boolean getAvail() {
		return avail;
	}

	public void setAvail(Boolean avail) {
		this.avail = avail;
	}

	public int getSemester() {
		return Semester;
	}

	public void setSemester(int semester) {
		Semester = semester;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Long getSID() {
		return SID;
	}

	public void setSID(Long sID) {
		SID = sID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Long getSellId() {
		return sellId;
	}

	public void setSellId(Long seller) {
		sellId = seller;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobno() {
		return Mobno;
	}

	public void setMobno(String mobno) {
		Mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", bkname=" + bkname + ", bkimg=" + bkimg + ", Condi=" + Condi + ", price=" + price
				+ ", avail=" + avail + ", Semester=" + Semester + ", Subject=" + Subject + ", SID=" + SID + ", student="
				+ student + ", Name=" + Name + ", Mobno=" + Mobno + ", email=" + email + "]";
	}
    
    
	 
	
	
}
