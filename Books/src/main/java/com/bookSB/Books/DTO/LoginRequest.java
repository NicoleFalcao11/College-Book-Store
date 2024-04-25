package com.bookSB.Books.DTO;

public class LoginRequest {
	
	private String email;
	
	private String Password;
	


	public LoginRequest() {
		
	}
	
	public LoginRequest(String email , String password
			 ) {
		this.email = email;
		this.Password = password;
	}


	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ",Password=" + Password + "]";
	}
	
	
	
}

