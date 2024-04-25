package com.bookSB.Books.DTO;

import java.util.ArrayList;
import java.util.List;

import com.bookSB.Books.Entity.Role;

public class SignupRequest {

	
	private Long RollNo;
	
	
	private String Name;
	
    
    private String Department;
    
    
    private String Year;
    
    
    private String Division;
	
	
	private String Password;
	
	
	private String MobNo;

	
	private String email;

	private String Rolename;

	public SignupRequest() {
		
	}
	
	public SignupRequest(Long rollNo, String name, String department, String year, String division, String password,
			String mobNo, String email , String Rolename) {
		super();
		RollNo = rollNo;
		Name = name;
		Department = department;
		Year = year;
		Division = division;
		Password = password;
		MobNo = mobNo;
		this.email = email;
		this.Rolename = Rolename;
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

	public String getRolename() {
		return Rolename;
	}

	public void setRolename(String Rolename) {
		this.Rolename = Rolename;
	}
//	public List<Role> getRoles(){
//		List<Role> roleList = new ArrayList<>();
//		Role role = new Role();
//		role.setRolename(Rolename);
//		roleList.add(role);
//		return roleList;
//	}
//	
//	public void setRoles(String Rolename) {
//		List<Role> roleList = new ArrayList<>();
//		Role role = new Role();
//		role.setRolename(Rolename);
//		roleList.add(role);
//		
//	}
	
	@Override
	public String toString() {
		return "SignupRequest [RollNo=" + RollNo + ", Name=" + Name + ", Department=" + Department + ", Year=" + Year
				+ ", Division=" + Division + ", Password=" + Password + ", MobNo=" + MobNo + ", email=" + email + ", Rolename=" + Rolename + "]";
	}
}
