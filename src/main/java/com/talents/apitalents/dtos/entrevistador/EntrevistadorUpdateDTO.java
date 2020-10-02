package com.talents.apitalents.dtos.entrevistador;

import java.io.Serializable;
import java.util.List;

import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteUpdateDTO;

public class EntrevistadorUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idGraduacao;
    private String nome;
    private String email;
    private String titulacao;
    private List<EntrevistadorEsporteUpdateDTO> entrevistadorEsporteUpdateDTOs;

    public EntrevistadorUpdateDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<EntrevistadorEsporteUpdateDTO> getEntrevistadorEsporteUpdateDTOs() {
        return entrevistadorEsporteUpdateDTOs;
    }

    public void setEntrevistadorEsporteUpdateDTOs(List<EntrevistadorEsporteUpdateDTO> entrevistadorEsporteUpdateDTOs) {
        this.entrevistadorEsporteUpdateDTOs = entrevistadorEsporteUpdateDTOs;
    }
}
