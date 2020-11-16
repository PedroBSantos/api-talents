package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.CustomUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {

    CustomUser findByUsername(String username);
}
