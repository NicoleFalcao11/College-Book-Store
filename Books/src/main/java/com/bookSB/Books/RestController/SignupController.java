package com.bookSB.Books.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookSB.Books.DTO.SignupRequest;
import com.bookSB.Books.Entity.Student;
import com.bookSB.Books.Service.StudentService;



@RestController
public class SignupController {

	private final StudentService authService;

    @Autowired
    public SignupController(StudentService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> signupStudent(@RequestBody SignupRequest signupRequest) {
    	System.out.println("\nIn SignUpController");
        System.out.println(signupRequest);
        Student createdStudent = authService.createStudent(signupRequest);
        if (createdStudent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Registration Failed ! Please Try Again");
        }
    }
    
    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestParam String email , @RequestParam String otp){
        try {
            authService.verify(email, otp);
            return new ResponseEntity<>("Welcome , You Have Been Verified Successfully",HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    
	
}
