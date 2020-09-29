package com.talents.apitalents.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.talents.apitalents.entities.Entrevista;

public class EntrevistaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDate dataEntrevista;
    private PerfilEntrevistadoDTO perfilEntrevistadoDTO;
    private EntrevistadoDTO entrevistadoDTO;
    private EntrevistadorDTO entrevistadorDTO;
    private EsporteDTO esporteDTO;

    public EntrevistaDTO() {
    }

    public EntrevistaDTO(Entrevista entrevista) {
        this.id = entrevista.getId();
        this.dataEntrevista = entrevista.getDataEntrevista();
        this.perfilEntrevistadoDTO = new PerfilEntrevistadoDTO(entrevista.getPerfilEntrevistado());
        this.entrevistadoDTO = new EntrevistadoDTO(entrevista.getEntrevistado());
        this.entrevistadorDTO = new EntrevistadorDTO(entrevista.getEntrevistador());
        this.esporteDTO = new EsporteDTO(entrevista.getEsporte());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrevista() {
        return dataEntrevista;
    }

    public void setDataEntrevista(LocalDate dataEntrevista) {
        this.dataEntrevista = dataEntrevista;
    }

    public PerfilEntrevistadoDTO getPerfilEntrevistadoDTO() {
        return perfilEntrevistadoDTO;
    }

    public void setPerfilEntrevistadoDTO(PerfilEntrevistadoDTO perfilEntrevistadoDTO) {
        this.perfilEntrevistadoDTO = perfilEntrevistadoDTO;
    }

    public EntrevistadoDTO getEntrevistadoDTO() {
        return entrevistadoDTO;
    }

    public void setEntrevistadoDTO(EntrevistadoDTO entrevistadoDTO) {
        this.entrevistadoDTO = entrevistadoDTO;
    }

    public EntrevistadorDTO getEntrevistadorDTO() {
        return entrevistadorDTO;
    }

    public void setEntrevistadorDTO(EntrevistadorDTO entrevistadorDTO) {
        this.entrevistadorDTO = entrevistadorDTO;
    }

    public EsporteDTO getEsporteDTO() {
        return esporteDTO;
    }

    public void setEsporteDTO(EsporteDTO esporteDTO) {
        this.esporteDTO = esporteDTO;
    }
}
