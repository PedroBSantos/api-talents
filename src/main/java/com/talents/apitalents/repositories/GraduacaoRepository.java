package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Graduacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduacaoRepository extends JpaRepository<Graduacao, Integer> {

}
