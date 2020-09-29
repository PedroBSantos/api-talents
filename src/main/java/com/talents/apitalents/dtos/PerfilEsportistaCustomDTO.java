package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.PerfilEsportistaCustom;

public class PerfilEsportistaCustomDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer agilidade;
    private Integer coordenacaoMotora;
    private Integer flexibilidade;
    private Integer forca;
    private Integer hipertrofia;
    private Integer potencia;
    private Integer resistencia;
    private Integer velocidade;
    private Integer envergaduraEstatura;
    private Integer comprPernasEstatura;
    private Integer alturaTroncoCefalicaEstatura;
    private Integer imc;

    public PerfilEsportistaCustomDTO() {
    }

    public PerfilEsportistaCustomDTO(PerfilEsportistaCustom perfilEsportistaCustom) {
        this.id = perfilEsportistaCustom.getId();
        this.agilidade = perfilEsportistaCustom.getAgilidade();
        this.coordenacaoMotora = perfilEsportistaCustom.getAgilidade();
        this.flexibilidade = perfilEsportistaCustom.getFlexibilidade();
        this.forca = perfilEsportistaCustom.getForca();
        this.hipertrofia = perfilEsportistaCustom.getHipertrofia();
        this.potencia = perfilEsportistaCustom.getPotencia();
        this.resistencia = perfilEsportistaCustom.getResistencia();
        this.velocidade = perfilEsportistaCustom.getVelocidade();
        this.envergaduraEstatura = perfilEsportistaCustom.getEnvergaduraEstatura();
        this.comprPernasEstatura = perfilEsportistaCustom.getComprPernasEstatura();
        this.alturaTroncoCefalicaEstatura = perfilEsportistaCustom.getAlturaTroncoCefalicaEstatura();
        this.imc = perfilEsportistaCustom.getImc();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getCoordenacaoMotora() {
        return coordenacaoMotora;
    }

    public void setCoordenacaoMotora(Integer coordenacaoMotora) {
        this.coordenacaoMotora = coordenacaoMotora;
    }

    public Integer getFlexibilidade() {
        return flexibilidade;
    }

    public void setFlexibilidade(Integer flexibilidade) {
        this.flexibilidade = flexibilidade;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getHipertrofia() {
        return hipertrofia;
    }

    public void setHipertrofia(Integer hipertrofia) {
        this.hipertrofia = hipertrofia;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getEnvergaduraEstatura() {
        return envergaduraEstatura;
    }

    public void setEnvergaduraEstatura(Integer envergaduraEstatura) {
        this.envergaduraEstatura = envergaduraEstatura;
    }

    public Integer getComprPernasEstatura() {
        return comprPernasEstatura;
    }

    public void setComprPernasEstatura(Integer comprPernasEstatura) {
        this.comprPernasEstatura = comprPernasEstatura;
    }

    public Integer getAlturaTroncoCefalicaEstatura() {
        return alturaTroncoCefalicaEstatura;
    }

    public void setAlturaTroncoCefalicaEstatura(Integer alturaTroncoCefalicaEstatura) {
        this.alturaTroncoCefalicaEstatura = alturaTroncoCefalicaEstatura;
    }

    public Integer getImc() {
        return imc;
    }

    public void setImc(Integer imc) {
        this.imc = imc;
    }
}
