package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.Graduacao;

public class GraduacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public GraduacaoDTO() {
    }

    public GraduacaoDTO(Graduacao graduacao) {
        this.id = graduacao.getId();
        this.nome = graduacao.getNome();
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
}
