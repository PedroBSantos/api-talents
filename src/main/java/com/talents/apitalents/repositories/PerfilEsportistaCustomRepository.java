package com.talents.apitalents.repositories;

import javax.transaction.Transactional;

import com.talents.apitalents.entities.PerfilEsportistaCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilEsportistaCustomRepository extends JpaRepository<PerfilEsportistaCustom, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE PerfilEsportistaCustom SET agilidade = :agilidade, coordenacao_motora = :coordenacaoMotora, "
            + "flexibilidade = :flexibilidade, forca = :forca, hipertrofia = :hipertrofia, potencia = :potencia, resistencia = :resistencia, "
            + "velocidade = :velocidade, envergadura_estatura = :envergaduraEstatura, compr_pernas_estatura = :comprPernasEstatura, "
            + "altura_tronco_cefalica_estatura = :alturaTroncoCefalicaEstatura, imc = :imc WHERE id = :id")
    void update(Integer id, Integer agilidade, Integer coordenacaoMotora, Integer flexibilidade, Integer forca,
            Integer hipertrofia, Integer potencia, Integer resistencia, Integer velocidade, Integer envergaduraEstatura,
            Integer comprPernasEstatura, Integer alturaTroncoCefalicaEstatura, Integer imc);
}
