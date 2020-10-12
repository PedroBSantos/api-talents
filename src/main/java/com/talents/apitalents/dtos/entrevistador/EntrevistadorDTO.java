package com.talents.apitalents.dtos.entrevistador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteDTO;
import com.talents.apitalents.dtos.graduacao.GraduacaoDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.EntrevistadorEsporte;

public class EntrevistadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String titulacao;
    private GraduacaoDTO graduacaoDTO;
    private List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs;

    public EntrevistadorDTO(Entrevistador entrevistador) {
        this.id = entrevistador.getId();
        this.nome = entrevistador.getNome();
        this.email = entrevistador.getEmail();
        this.titulacao = entrevistador.getTitulacao();
        this.graduacaoDTO = new GraduacaoDTO(entrevistador.getGraduacao());
        this.entrevistadorEsporteDTOs = new ArrayList<>();
        for (EntrevistadorEsporte entrevistadorEsporte : entrevistador.getEntrevistadorEsportes()) {
            this.entrevistadorEsporteDTOs.add(new EntrevistadorEsporteDTO(entrevistadorEsporte));
        }
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

    public List<EntrevistadorEsporteDTO> getEntrevistadorEsporteDTOs() {
        return entrevistadorEsporteDTOs;
    }

    public void setEntrevistadorEsporteDTOs(List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs) {
        this.entrevistadorEsporteDTOs = entrevistadorEsporteDTOs;
    }
}
