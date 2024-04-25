package com.bookSB.Books.RestController;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookSB.Books.DTO.LoginRequest;
import com.bookSB.Books.DTO.LoginResponse;
import com.bookSB.Books.Entity.Student;
import com.bookSB.Books.Repository.StudentRepository;
import com.bookSB.Books.Service.JWT.StudentService;
import com.bookSB.Books.Utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final StudentService customerService;
    private final StudentRepository srepo;
    private final JwtUtil jwtUtil;


    @Autowired
    public LoginController(AuthenticationManager authenticationManager, StudentService customerService, StudentRepository srepo ,JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;
        this.srepo = srepo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect Email Or Password");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student Does Not Exist");
            return null;
        }
        final UserDetails userDetails = customerService.loadUserByUsername(loginRequest.getEmail());
        String email =  userDetails.getUsername();
        Student s = new Student();
        s = srepo.findByEmail(email);
        Long rollno = s.getRollNo();
        String name = s.getName();
        final String jwt = jwtUtil.generateToken(userDetails.getUsername() , rollno , name);
        //REFRESH TOKEN
        final String refreshToken = jwtUtil.generateRefreshToken(new HashMap<>() , userDetails.getUsername());

        return new LoginResponse(jwt , refreshToken);
        
    }

}