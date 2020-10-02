package com.talents.apitalents.dtos.estado;

import com.talents.apitalents.entities.Estado;

public class EstadoDTO {

    private Integer id;
    private String nome;
    private String sigla;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.sigla = estado.getSigla();
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
