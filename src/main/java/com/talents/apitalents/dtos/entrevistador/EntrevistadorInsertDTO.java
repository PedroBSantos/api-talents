package com.talents.apitalents.dtos.entrevistador;

import java.io.Serializable;
import java.util.List;

import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteInsertDTO;

public class EntrevistadorInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idGraduacao;
    private String nome;
    private String email;
    private String titulacao;
    private List<EntrevistadorEsporteInsertDTO> entrevistadorEsporteInsertDTOs;

    public EntrevistadorInsertDTO() {
    }

    public Integer getIdGraduacao() {
        return idGraduacao;
    }

    public void setIdGraduacao(Integer idGraduacao) {
        this.idGraduacao = idGraduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public List<EntrevistadorEsporteInsertDTO> getEntrevistadorEsporteInsertDTOs() {
        return entrevistadorEsporteInsertDTOs;
    }

    public void setEntrevistadorEsporteInsertDTOs(List<EntrevistadorEsporteInsertDTO> entrevistadorEsporteInsertDTOs) {
        this.entrevistadorEsporteInsertDTOs = entrevistadorEsporteInsertDTOs;
    }
}
