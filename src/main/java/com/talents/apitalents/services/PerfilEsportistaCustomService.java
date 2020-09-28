package com.talents.apitalents.services;

import com.talents.apitalents.dto.PerfilEsportistaCustomDTO;
import com.talents.apitalents.entities.PerfilEsportistaCustom;
import com.talents.apitalents.repository.PerfilEsportistaCustomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilEsportistaCustomService {

    @Autowired
    private PerfilEsportistaCustomRepository perfilEsportistaCustomRepository;

    @Transactional(readOnly = false)
    public PerfilEsportistaCustom create(PerfilEsportistaCustomDTO perfilEsportistaCustomDTO) {
        Integer agilidade = perfilEsportistaCustomDTO.getAgilidade();
        Integer coordenacaoMotora = perfilEsportistaCustomDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilEsportistaCustomDTO.getFlexibilidade();
        Integer forca = perfilEsportistaCustomDTO.getForca();
        Integer hipertrofia = perfilEsportistaCustomDTO.getHipertrofia();
        Integer potencia = perfilEsportistaCustomDTO.getPotencia();
        Integer resistencia = perfilEsportistaCustomDTO.getResistencia();
        Integer velocidade = perfilEsportistaCustomDTO.getVelocidade();
        Integer envergaduraEstatura = perfilEsportistaCustomDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEsportistaCustomDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEsportistaCustomDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEsportistaCustomDTO.getImc();
        PerfilEsportistaCustom perfilEsportistaCustom = new PerfilEsportistaCustom(agilidade, coordenacaoMotora,
                flexibilidade, forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura,
                comprPernasEstatura, alturaTroncoCefalicaEstatura, imc);
        perfilEsportistaCustom = this.perfilEsportistaCustomRepository.save(perfilEsportistaCustom);
        return perfilEsportistaCustom;
    }

    public PerfilEsportistaCustomDTO update(PerfilEsportistaCustomDTO perfilEsportistaCustomDTO) {
        Integer idPerfilEsportistaCustom = perfilEsportistaCustomDTO.getId();
        Integer agilidade = perfilEsportistaCustomDTO.getAgilidade();
        Integer coordenacaoMotora = perfilEsportistaCustomDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilEsportistaCustomDTO.getFlexibilidade();
        Integer forca = perfilEsportistaCustomDTO.getForca();
        Integer hipertrofia = perfilEsportistaCustomDTO.getHipertrofia();
        Integer potencia = perfilEsportistaCustomDTO.getPotencia();
        Integer resistencia = perfilEsportistaCustomDTO.getResistencia();
        Integer velocidade = perfilEsportistaCustomDTO.getVelocidade();
        Integer envergaduraEstatura = perfilEsportistaCustomDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEsportistaCustomDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEsportistaCustomDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEsportistaCustomDTO.getImc();
        this.perfilEsportistaCustomRepository.update(idPerfilEsportistaCustom, agilidade, coordenacaoMotora,
                flexibilidade, forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura,
                comprPernasEstatura, alturaTroncoCefalicaEstatura, imc);
        return perfilEsportistaCustomDTO;
    }

    @Transactional(readOnly = false)
    @Modifying
    public PerfilEsportistaCustomDTO delete(PerfilEsportistaCustomDTO perfilEsportistaCustomDTO) {
        Integer idPerfilEsportistaCustom = perfilEsportistaCustomDTO.getId();
        this.perfilEsportistaCustomRepository.deleteById(idPerfilEsportistaCustom);
        return perfilEsportistaCustomDTO;
    }
}
