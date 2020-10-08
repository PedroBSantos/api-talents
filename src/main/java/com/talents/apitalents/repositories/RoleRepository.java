package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Role findByName(String nome);
}
