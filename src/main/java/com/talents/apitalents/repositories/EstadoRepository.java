package com.talents.apitalents.repositories;

import java.util.List;

import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.entities.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT cidade FROM Cidade cidade WHERE id_estado = :id")
    List<Cidade> findCidades(Integer id);

    Estado findBySigla(String sigla);
}
