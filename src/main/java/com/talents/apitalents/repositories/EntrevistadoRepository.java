package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Entrevistado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistadoRepository extends JpaRepository<Entrevistado, Integer> {

    Entrevistado findByEmail(String email);
}
