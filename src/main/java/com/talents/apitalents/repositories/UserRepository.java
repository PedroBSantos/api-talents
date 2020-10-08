package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);
}
