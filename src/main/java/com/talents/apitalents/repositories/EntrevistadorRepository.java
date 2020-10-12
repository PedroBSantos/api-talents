package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Entrevistador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrevistadorRepository extends JpaRepository<Entrevistador, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Entrevistador SET nome = :nome, email = :email, titulacao = :titulacao, "
            + "id_graduacao = :idGraduacao WHERE id = :idEntrevistador")
    void update(String nome, String email, String titulacao, Integer idGraduacao, Integer idEntrevistador);

    Entrevistador findByEmail(String email);
}
