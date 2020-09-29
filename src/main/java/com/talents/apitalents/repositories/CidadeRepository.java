package com.talents.apitalents.repositories;

import java.util.List;

import com.talents.apitalents.entities.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("SELECT cidade FROM Cidade cidade WHERE id_estado = :idEstado")
    List<Cidade> findByIdEstado(Integer idEstado);
}
