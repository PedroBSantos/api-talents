package com.talents.apitalents.dtos.usuario;

import java.io.Serializable;

import com.talents.apitalents.entities.Funcao;

public class FuncaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;

    public FuncaoDTO(Funcao funcao) {
        this.nome = funcao.getAuthority();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
