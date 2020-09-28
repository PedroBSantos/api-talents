package com.talents.apitalents.repositories;

import java.time.LocalDate;

import com.talents.apitalents.entities.Entrevistado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrevistadoRepository extends JpaRepository<Entrevistado, Integer> {

        @Transactional
        @Modifying
        @Query("UPDATE Entrevistado SET nome = :nome, cpf = :cpf, rg = :rg, nome_mae = :nomeMae, email = :email, "
                        + "sexo = :sexo, etnia = :etnia, telefone = :telefone, data_nascimento = :dataNascimento WHERE id = "
                        + ":idEntrevistado")
        void update(String nome, String cpf, String rg, String nomeMae, String email, String sexo, String etnia,
                        String telefone, LocalDate dataNascimento, Integer idEntrevistado);
}
