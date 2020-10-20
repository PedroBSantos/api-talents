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
    @Query("UPDATE Endereco SET cep = :cep, logradouro = :logradouro, complemento = :complemento, bairro = :bairro, localidade = :localidade, uf = :uf WHERE id = :idEndereco")
    void update(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
            Integer idEndereco);
}
