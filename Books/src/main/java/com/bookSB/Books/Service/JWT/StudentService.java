package com.bookSB.Books.Service.JWT;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookSB.Books.Entity.Student;
import com.bookSB.Books.Repository.StudentRepository;
//Determines if Any user with claimed email actually exists , if exists creates an User class instance for spring 
//securities further use


@Service
public class StudentService implements UserDetailsService {

	private final StudentRepository srepo;

    @Autowired
    public StudentService(StudentRepository srepo) {
        this.srepo = srepo;
    }
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Student s = srepo.findByEmail(email);
		if (s == null) {
		    throw new UsernameNotFoundException("Student with email: " + email + " doesn't exist");
		}

        return new User(s.getEmail(), s.getPassword(), Collections.emptyList());
	}
   

}

