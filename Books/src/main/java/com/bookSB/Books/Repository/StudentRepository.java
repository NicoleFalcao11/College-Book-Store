package com.bookSB.Books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookSB.Books.Entity.Student;

public interface StudentRepository extends JpaRepository <Student , Long>{
		
	     Student findFirstByEmail(String email);
	     
	     boolean existsByEmail(String email);
         Student findByEmail(String email);
	 }
