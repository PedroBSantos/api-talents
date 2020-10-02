package com.talents.apitalents.dtos.entrevistador.esporte;

import java.io.Serializable;

import com.talents.apitalents.dtos.perfil.PerfilDTO;

public class EntrevistadorEsporteUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idEsporte;
    private String abrangencia;
    private Integer tempoExpertise;
    private PerfilDTO perfilDTO;

    public EntrevistadorEsporteUpdateDTO() {
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

    public PerfilDTO getPerfilDTO() {
        return perfilDTO;
    }

    public void setPerfilDTO(PerfilDTO perfilDTO) {
        this.perfilDTO = perfilDTO;
    }

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }
}
