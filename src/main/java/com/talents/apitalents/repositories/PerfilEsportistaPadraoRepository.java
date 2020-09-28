package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.PerfilEsportistaPadrao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilEsportistaPadraoRepository extends JpaRepository<PerfilEsportistaPadrao, Integer> {

}
