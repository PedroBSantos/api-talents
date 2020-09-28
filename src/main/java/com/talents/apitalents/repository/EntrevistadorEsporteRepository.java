package com.talents.apitalents.repository;

import java.util.List;

import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.EntrevistadorEsporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrevistadorEsporteRepository extends JpaRepository<EntrevistadorEsporte, Integer> {

    List<EntrevistadorEsporte> findByEntrevistador(Entrevistador entrevistador);

    @Transactional
    @Modifying
    @Query("UPDATE EntrevistadorEsporte SET abrangencia = :abrangencia, tempoExpertise = :tempoExpertise, "
            + "id_perfil_esportista_custom = :idPerfilEsportistaCustom, id_esporte = :idEsporte WHERE id = :idEntrevistadorEsporte")
    void update(Integer idEntrevistadorEsporte, String abrangencia, Integer tempoExpertise,
            Integer idPerfilEsportistaCustom, Integer idEsporte);
}
