package com.talents.apitalents.repositories;

import java.time.LocalDate;
import java.util.List;

import com.talents.apitalents.entities.Entrevista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrevistaRepository extends JpaRepository<Entrevista, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Entrevista SET data_entrevista = :dataEntrevista, id_entrevistado = "
            + ":idEntrevistado, id_entrevistador = :idEntrevistador, id_esporte = :idEsporte, "
            + "id_perfil_entrevistado = :idPerfilEntrevistado WHERE id = :idEntrevista")
    void update(Integer idEntrevista, LocalDate dataEntrevista, Integer idEntrevistado, Integer idEntrevistador,
                    Integer idEsporte, Integer idPerfilEntrevistado);

    @Query("SELECT entrevista FROM Entrevista entrevista WHERE id_entrevistado = :entrevistado")
    List<Entrevista> findByEntrevistado(Integer entrevistado);

    @Query("SELECT entrevista FROM Entrevista entrevista WHERE id_entrevistador = :entrevistador")
    List<Entrevista> findByEntrevistador(Integer entrevistador);
}
