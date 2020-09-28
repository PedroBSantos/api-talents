package com.talents.apitalents.dto;

import java.io.Serializable;

import com.talents.apitalents.entities.EntrevistadorEsporte;

public class EntrevistadorEsporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String abrangencia;
    private Integer tempoExpertise;
    private EsporteDTO esporteDTO;
    private PerfilEsportistaCustomDTO perfilEsportistaCustomDTO;
    private EntrevistadorDTO entrevistadorDTO;

    public EntrevistadorEsporteDTO() {
    }

    public EntrevistadorEsporteDTO(EntrevistadorEsporte entrevistadorEsporte) {
        this.id = entrevistadorEsporte.getId();
        this.abrangencia = entrevistadorEsporte.getAbrangencia();
        this.tempoExpertise = entrevistadorEsporte.getTempoExpertise();
        this.perfilEsportistaCustomDTO = new PerfilEsportistaCustomDTO(
                entrevistadorEsporte.getPerfilEsportistaCustom());
        this.entrevistadorDTO = new EntrevistadorDTO(entrevistadorEsporte.getEntrevistador());
        this.esporteDTO = new EsporteDTO(entrevistadorEsporte.getEsporte());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(String abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Integer getTempoExpertise() {
        return tempoExpertise;
    }

    public void setTempoExpertise(Integer tempoExpertise) {
        this.tempoExpertise = tempoExpertise;
    }

    public EsporteDTO getEsporteDTO() {
        return esporteDTO;
    }

    public void setEsporteDTO(EsporteDTO esporteDTO) {
        this.esporteDTO = esporteDTO;
    }

    public PerfilEsportistaCustomDTO getPerfilEsportistaCustomDTO() {
        return perfilEsportistaCustomDTO;
    }

    public void setPerfilEsportistaCustomDTO(PerfilEsportistaCustomDTO perfilEsportistaCustomDTO) {
        this.perfilEsportistaCustomDTO = perfilEsportistaCustomDTO;
    }

    public EntrevistadorDTO getEntrevistadorDTO() {
        return entrevistadorDTO;
    }

    public void setEntrevistadorDTO(EntrevistadorDTO entrevistadorDTO) {
        this.entrevistadorDTO = entrevistadorDTO;
    }
}