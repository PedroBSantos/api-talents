package com.talents.apitalents.repositories;

import java.util.List;

import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.entities.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findByEstado(Estado estado);
}
