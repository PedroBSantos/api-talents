package com.talents.apitalents.dtos.cidade;

import java.io.Serializable;

import com.talents.apitalents.dtos.estado.EstadoDTO;
import com.talents.apitalents.entities.Cidade;

public class CidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private EstadoDTO estadoDTO;

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.estadoDTO = new EstadoDTO(cidade.getEstado());
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

    public EstadoDTO getEstadoDTO() {
        return estadoDTO;
    }

    public void setEstadoDTO(EstadoDTO estadoDTO) {
        this.estadoDTO = estadoDTO;
    }
}
