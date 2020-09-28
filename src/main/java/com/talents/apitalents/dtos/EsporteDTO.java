package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.Esporte;

public class EsporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private PerfilEsportistaPadraoDTO perfilEsportistaPadraoDTO;

    public EsporteDTO() {
    }

    public EsporteDTO(Esporte esporte) {
        this.id = esporte.getId();
        this.nome = esporte.getNome();
        this.perfilEsportistaPadraoDTO = new PerfilEsportistaPadraoDTO(esporte.getPerfilEsportistaPadrao());
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

    public PerfilEsportistaPadraoDTO getPerfilEsportistaPadraoDTO() {
        return perfilEsportistaPadraoDTO;
    }

    public void setPerfilEsportistaPadraoDTO(PerfilEsportistaPadraoDTO perfilEsportistaPadraoDTO) {
        this.perfilEsportistaPadraoDTO = perfilEsportistaPadraoDTO;
    }
}
