package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Esporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsporteRepository extends JpaRepository<Esporte, Integer> {
    
}
