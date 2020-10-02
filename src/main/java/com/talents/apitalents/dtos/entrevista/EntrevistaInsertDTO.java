package com.talents.apitalents.dtos.entrevista;

import java.io.Serializable;
import java.time.LocalDate;

import com.talents.apitalents.dtos.perfil.PerfilInsertDTO;

public class EntrevistaInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idEntrevistado;
    private Integer idEntrevistador;
    private Integer idEsporte;
    private LocalDate dataEntrevista;
    private PerfilInsertDTO perfilEntrevistado;

    public EntrevistaInsertDTO() {
    }

    public Integer getIdEntrevistado() {
        return idEntrevistado;
    }

    public void setIdEntrevistado(Integer idEntrevistado) {
        this.idEntrevistado = idEntrevistado;
    }

    public Integer getIdEntrevistador() {
        return idEntrevistador;
    }

    public void setIdEntrevistador(Integer idEntrevistador) {
        this.idEntrevistador = idEntrevistador;
    }

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }

    public LocalDate getDataEntrevista() {
        return dataEntrevista;
    }

    public void setDataEntrevista(LocalDate dataEntrevista) {
        this.dataEntrevista = dataEntrevista;
    }

    public PerfilInsertDTO getPerfilEntrevistado() {
        return perfilEntrevistado;
    }

    public void setPerfilEntrevistado(PerfilInsertDTO perfilEntrevistado) {
        this.perfilEntrevistado = perfilEntrevistado;
    }
}
