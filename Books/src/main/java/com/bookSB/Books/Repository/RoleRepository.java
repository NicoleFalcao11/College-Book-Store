package com.bookSB.Books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookSB.Books.Entity.Role;

public interface RoleRepository extends JpaRepository <Role , Long> {

}
