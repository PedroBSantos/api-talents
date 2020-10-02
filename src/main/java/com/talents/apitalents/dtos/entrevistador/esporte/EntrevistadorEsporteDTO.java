package com.talents.apitalents.dtos.entrevistador.esporte;

import java.io.Serializable;

import com.talents.apitalents.dtos.esporte.EsporteDTO;
import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.entities.EntrevistadorEsporte;
import com.talents.apitalents.entities.PerfilEsportistaCustom;

public class EntrevistadorEsporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idEntrevistador;
    private String abrangencia;
    private Integer tempoExpertise;
    private EsporteDTO esporteDTO;
    private PerfilDTO perfilCustom;

    public EntrevistadorEsporteDTO(EntrevistadorEsporte entrevistadorEsporte) {
        this.id = entrevistadorEsporte.getId();
        this.abrangencia = entrevistadorEsporte.getAbrangencia();
        this.tempoExpertise = entrevistadorEsporte.getTempoExpertise();
        this.idEntrevistador = entrevistadorEsporte.getEntrevistador().getId();
        this.esporteDTO = new EsporteDTO(entrevistadorEsporte.getEsporte());
        PerfilEsportistaCustom perfilEsportistaCustom = entrevistadorEsporte.getPerfilEsportistaCustom();
        Integer id = perfilEsportistaCustom.getId();
        Integer agilidade = perfilEsportistaCustom.getAgilidade();
        Integer coordenacaoMotora = perfilEsportistaCustom.getCoordenacaoMotora();
        Integer flexibilidade = perfilEsportistaCustom.getFlexibilidade();
        Integer forca = perfilEsportistaCustom.getForca();
        Integer hipertrofia = perfilEsportistaCustom.getHipertrofia();
        Integer potencia = perfilEsportistaCustom.getPotencia();
        Integer resistencia = perfilEsportistaCustom.getResistencia();
        Integer velocidade = perfilEsportistaCustom.getVelocidade();
        Integer envergaduraEstatura = perfilEsportistaCustom.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEsportistaCustom.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEsportistaCustom.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEsportistaCustom.getImc();
        this.perfilCustom = new PerfilDTO(id, agilidade, coordenacaoMotora, flexibilidade, forca, hipertrofia, potencia,
                resistencia, velocidade, envergaduraEstatura, comprPernasEstatura, alturaTroncoCefalicaEstatura, imc);
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

    public Integer getIdEntrevistador() {
        return idEntrevistador;
    }

    public void setIdEntrevistador(Integer idEntrevistador) {
        this.idEntrevistador = idEntrevistador;
    }

    public PerfilDTO getPerfilCustom() {
        return perfilCustom;
    }

    public void setPerfilCustom(PerfilDTO perfilCustom) {
        this.perfilCustom = perfilCustom;
    }
}
