package com.talents.apitalents.dtos.entrevistador.esporte;

import java.io.Serializable;

import com.talents.apitalents.dtos.perfil.PerfilInsertDTO;

public class EntrevistadorEsporteInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idEntrevistador;
    private String abrangencia;
    private Integer tempoExpertise;
    private Integer idEsporte;
    private PerfilInsertDTO perfilInsertDTO;

    public EntrevistadorEsporteInsertDTO() {
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

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }

    public PerfilInsertDTO getPerfilInsertDTO() {
        return perfilInsertDTO;
    }

    public void setPerfilInsertDTO(PerfilInsertDTO perfilInsertDTO) {
        this.perfilInsertDTO = perfilInsertDTO;
    }

    public Integer getIdEntrevistador() {
        return idEntrevistador;
    }

    public void setIdEntrevistador(Integer idEntrevistador) {
        this.idEntrevistador = idEntrevistador;
    }
}
