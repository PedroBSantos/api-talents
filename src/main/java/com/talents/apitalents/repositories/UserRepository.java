package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.CustomUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CustomUser, Integer> {
    
    CustomUser findByUsername(String username);
}
