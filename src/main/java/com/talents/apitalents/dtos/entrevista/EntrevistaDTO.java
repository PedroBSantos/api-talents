package com.talents.apitalents.dtos.entrevista;

import java.io.Serializable;
import java.time.LocalDate;

import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.entities.Entrevista;
import com.talents.apitalents.entities.PerfilEntrevistado;

public class EntrevistaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idEntrevistado;
    private Integer idEntrevistador;
    private Integer idEsporte;
    private LocalDate dataEntrevista;
    private PerfilDTO perfilEntrevistadoDTO;

    public EntrevistaDTO() {
    }

    public EntrevistaDTO(Entrevista entrevista) {
        this.id = entrevista.getId();
        this.idEntrevistado = entrevista.getEntrevistado().getId();
        this.idEntrevistador = entrevista.getEntrevistador().getId();
        this.idEsporte = entrevista.getEsporte().getId();
        this.dataEntrevista = entrevista.getDataEntrevista();
        PerfilEntrevistado perfilEntrevistado = entrevista.getPerfilEntrevistado();
        Integer id = perfilEntrevistado.getId();
        Integer agilidade = perfilEntrevistado.getAgilidade();
        Integer coordenacaoMotora = perfilEntrevistado.getCoordenacaoMotora();
        Integer flexibilidade = perfilEntrevistado.getFlexibilidade();
        Integer forca = perfilEntrevistado.getForca();
        Integer hipertrofia = perfilEntrevistado.getHipertrofia();
        Integer potencia = perfilEntrevistado.getPotencia();
        Integer resistencia = perfilEntrevistado.getResistencia();
        Integer velocidade = perfilEntrevistado.getVelocidade();
        Integer envergaduraEstatura = perfilEntrevistado.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEntrevistado.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEntrevistado.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEntrevistado.getImc();
        this.perfilEntrevistadoDTO = new PerfilDTO(id, agilidade, coordenacaoMotora, flexibilidade, forca, hipertrofia,
                potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PerfilDTO getPerfilEntrevistadoDTO() {
        return perfilEntrevistadoDTO;
    }

    public void setPerfilEntrevistadoDTO(PerfilDTO perfilEntrevistadoDTO) {
        this.perfilEntrevistadoDTO = perfilEntrevistadoDTO;
    }
}
