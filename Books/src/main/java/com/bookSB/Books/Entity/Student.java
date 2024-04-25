package com.bookSB.Books.Entity;


import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name = "RollNo")
	private Long RollNo;
	
	@Column(name = "Name")
	private String Name;
	
    @Column(name = "Department")
    private String Department;
    
    @Column(name = "Year")
    private String Year;
    
    @Column(name = "Division")
    private String Division;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "MobNo")
	private String MobNo;

	@Column(name = "email")
	private String email;
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "verified")
    private boolean verified;
	
	@OneToMany(mappedBy = "student_id",fetch = FetchType.LAZY)
    private List<Role> role;
	
	@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL ,fetch = FetchType.LAZY )
    private List<Book> books;
	
	public Student() {
		
	}

	public Student(Long rollNo, String name, String department, String year, String division, String password,
			String mobNo, String email,String otp, boolean verified , List<Role> role, List<Book> books) {
		super();
		RollNo = rollNo;
		Name = name;
		Department = department;
		Year = year;
		Division = division;
		Password = password;
		MobNo = mobNo;
		this.email = email;
		this.otp = otp;
		this.verified = verified;
		this.role = role;
		this.books = books;
	}

	public Long getRollNo() {
		return RollNo;
	}

	public void setRollNo(Long rollNo) {
		RollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getDivision() {
		return Division;
	}

	public void setDivision(String division) {
		Division = division;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobNo() {
		return MobNo;
	}

	public void setMobNo(String mobNo) {
		MobNo = mobNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<Role> getRoles() {
		return role;
	}

	public void setRoles(List<Role> roles) {
		this.role = roles;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", Name=" + Name + ", Department=" + Department + ", Year=" + Year
				+ ", Division=" + Division + ", Password=" + Password + ", MobNo=" + MobNo + ", email=" + email
				+", otp=" + otp + ", verified=" + verified + ", roles=" + role + ", books=" + books + "]";
	}
	
    


}
