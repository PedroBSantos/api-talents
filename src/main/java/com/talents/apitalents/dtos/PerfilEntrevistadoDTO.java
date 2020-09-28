package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.PerfilEntrevistado;

public class PerfilEntrevistadoDTO implements Serializable {
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

    public PerfilEntrevistadoDTO() {
    }

    public PerfilEntrevistadoDTO(PerfilEntrevistado perfilEntrevistado) {
        this.id = perfilEntrevistado.getId();
        this.agilidade = perfilEntrevistado.getAgilidade();
        this.coordenacaoMotora = perfilEntrevistado.getAgilidade();
        this.flexibilidade = perfilEntrevistado.getFlexibilidade();
        this.forca = perfilEntrevistado.getForca();
        this.hipertrofia = perfilEntrevistado.getHipertrofia();
        this.potencia = perfilEntrevistado.getPotencia();
        this.resistencia = perfilEntrevistado.getResistencia();
        this.velocidade = perfilEntrevistado.getVelocidade();
        this.envergaduraEstatura = perfilEntrevistado.getEnvergaduraEstatura();
        this.comprPernasEstatura = perfilEntrevistado.getComprPernasEstatura();
        this.alturaTroncoCefalicaEstatura = perfilEntrevistado.getAlturaTroncoCefalicaEstatura();
        this.imc = perfilEntrevistado.getImc();
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
