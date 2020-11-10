package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Entrevistador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistadorRepository extends JpaRepository<Entrevistador, Integer> {

    Entrevistador findByEmail(String email);
}
