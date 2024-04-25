package com.bookSB.Books.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Role_Id")
	private Long Role_Id;
	
	@Column(name = "Rolename")
	private String Rolename;
	
	@ManyToOne
	@JoinColumn(name = "student_Id")
	private Student student_id;
	
	@Transient
	 private Long rollno;
	 
	 private String name;

	 @Transient
	 private String email;

	public Role(Long role_Id, String rolename, Student student_id, Long rollno, String name, String email) {
		super();
		Role_Id = role_Id;
		Rolename = rolename;
		this.student_id = student_id;
		this.rollno = rollno;
		this.name = name;
		this.email = email;
	}
	
	public Role() {
		
	}

	public Long getRole_Id() {
		return Role_Id;
	}

	public void setRole_Id(Long role_Id) {
		Role_Id = role_Id;
	}

	public String getRolename() {
		return Rolename;
	}

	public void setRolename(String rolename) {
		Rolename = rolename;
	}

	public Student getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Role [Role_Id=" + Role_Id + ", Rolename=" + Rolename + ", student_id=" + student_id + ", rollno="
				+ rollno + ", name=" + name + ", email=" + email + "]";
	}
	
}
	

