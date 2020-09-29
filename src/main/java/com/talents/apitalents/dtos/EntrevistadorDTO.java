package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.Entrevistador;

public class EntrevistadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String titulacao;
    private GraduacaoDTO graduacaoDTO;

    public EntrevistadorDTO() {
    }

    public EntrevistadorDTO(Entrevistador entrevistador) {
        this.id = entrevistador.getId();
        this.nome = entrevistador.getNome();
        this.email = entrevistador.getEmail();
        this.titulacao = entrevistador.getTitulacao();
        this.graduacaoDTO = new GraduacaoDTO(entrevistador.getGraduacao());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public GraduacaoDTO getGraduacaoDTO() {
        return graduacaoDTO;
    }

    public void setGraduacaoDTO(GraduacaoDTO graduacaoDTO) {
        this.graduacaoDTO = graduacaoDTO;
    }
}
