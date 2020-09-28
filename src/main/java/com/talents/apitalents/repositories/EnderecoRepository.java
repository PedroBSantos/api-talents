package com.talents.apitalents.repositories;

import com.talents.apitalents.entities.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Endereco SET rua = :rua, bairro = :bairro, complemento = :complemento, id_cidade = :idCidade WHERE id = :idEndereco")
    void update(String rua, String bairro, String complemento, Integer idCidade, Integer idEndereco);
}
