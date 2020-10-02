package com.talents.apitalents.dtos.esporte;

import java.io.Serializable;

import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.entities.Esporte;

public class EsporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private PerfilDTO perfilDTO;

    public EsporteDTO(Esporte esporte) {
        this.id = esporte.getId();
        this.nome = esporte.getNome();
        Integer idPerfil = esporte.getPerfilEsportistaPadrao().getId();
        Integer agilidade = esporte.getPerfilEsportistaPadrao().getAgilidade();
        Integer coordenacaoMotora = esporte.getPerfilEsportistaPadrao().getCoordenacaoMotora();
        Integer flexibilidade = esporte.getPerfilEsportistaPadrao().getFlexibilidade();
        Integer forca = esporte.getPerfilEsportistaPadrao().getForca();
        Integer hipertrofia = esporte.getPerfilEsportistaPadrao().getHipertrofia();
        Integer potencia = esporte.getPerfilEsportistaPadrao().getPotencia();
        Integer resistencia = esporte.getPerfilEsportistaPadrao().getResistencia();
        Integer velocidade = esporte.getPerfilEsportistaPadrao().getVelocidade();
        Integer envergaduraEstatura = esporte.getPerfilEsportistaPadrao().getEnvergaduraEstatura();
        Integer comprPernasEstatura = esporte.getPerfilEsportistaPadrao().getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = esporte.getPerfilEsportistaPadrao().getAlturaTroncoCefalicaEstatura();
        Integer imc = esporte.getPerfilEsportistaPadrao().getImc();
        this.perfilDTO = new PerfilDTO(idPerfil, agilidade, coordenacaoMotora, flexibilidade, forca, hipertrofia,
                potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PerfilDTO getPerfilDTO() {
        return perfilDTO;
    }

    public void setPerfilDTO(PerfilDTO perfilDTO) {
        this.perfilDTO = perfilDTO;
    }
}
