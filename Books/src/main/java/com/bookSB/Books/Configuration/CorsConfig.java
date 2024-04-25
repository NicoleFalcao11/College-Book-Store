package com.bookSB.Books.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000" , "https://main.da9b5grihc737.amplifyapp.com" , "http://bookstorebucket.s3-website.ap-south-1.amazonaws.com") 
            .allowedMethods("OPTIONS" ,"GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Authorization", "Content-Type", "Access-Control-Allow-Origin")
            .allowedHeaders("*");
    }
}
