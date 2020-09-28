package com.talents.apitalents.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PerfilEsportistaPadrao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "perfilEsportistaPadrao")
    private Esporte esporte;
    @Column(nullable = false)
    private Integer agilidade;
    @Column(nullable = false)
    private Integer coordenacaoMotora;
    @Column(nullable = false)
    private Integer flexibilidade;
    @Column(nullable = false)
    private Integer forca;
    @Column(nullable = false)
    private Integer hipertrofia;
    @Column(nullable = false)
    private Integer potencia;
    @Column(nullable = false)
    private Integer resistencia;
    @Column(nullable = false)
    private Integer velocidade;
    @Column(nullable = false)
    private Integer envergaduraEstatura;
    @Column(nullable = false)
    private Integer comprPernasEstatura;
    @Column(nullable = false)
    private Integer alturaTroncoCefalicaEstatura;
    @Column(nullable = false)
    private Integer imc;

    public PerfilEsportistaPadrao() {
    }

    public PerfilEsportistaPadrao(Integer agilidade, Integer coordenacaoMotora, Integer flexibilidade,
            Integer forca, Integer hipertrofia, Integer potencia, Integer resistencia, Integer velocidade,
            Integer envergaduraEstatura, Integer comprPernasEstatura, Integer alturaTroncoCefalicaEstatura,
            Integer imc) {
        this.agilidade = agilidade;
        this.coordenacaoMotora = coordenacaoMotora;
        this.flexibilidade = flexibilidade;
        this.forca = forca;
        this.hipertrofia = hipertrofia;
        this.potencia = potencia;
        this.resistencia = resistencia;
        this.velocidade = velocidade;
        this.envergaduraEstatura = envergaduraEstatura;
        this.comprPernasEstatura = comprPernasEstatura;
        this.alturaTroncoCefalicaEstatura = alturaTroncoCefalicaEstatura;
        this.imc = imc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PerfilEsportistaPadrao other = (PerfilEsportistaPadrao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
