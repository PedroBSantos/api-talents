package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.CustomRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<CustomRole, Integer> {
    
    CustomRole findByName(String nome);
}
