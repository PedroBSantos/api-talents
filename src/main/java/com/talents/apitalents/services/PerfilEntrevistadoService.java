package com.talents.apitalents.services;

import com.talents.apitalents.dtos.PerfilEntrevistadoDTO;
import com.talents.apitalents.entities.PerfilEntrevistado;
import com.talents.apitalents.repositories.PerfilEntrevistadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilEntrevistadoService {

    @Autowired
    private PerfilEntrevistadoRepository perfilEntrevistadoRepository;

    @Transactional(readOnly = false)
    public PerfilEntrevistado create(PerfilEntrevistadoDTO perfilEntrevistadoDTO) {
        Integer agilidade = perfilEntrevistadoDTO.getAgilidade();
        Integer coordenacaoMotora = perfilEntrevistadoDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilEntrevistadoDTO.getFlexibilidade();
        Integer forca = perfilEntrevistadoDTO.getForca();
        Integer hipertrofia = perfilEntrevistadoDTO.getHipertrofia();
        Integer potencia = perfilEntrevistadoDTO.getPotencia();
        Integer resistencia = perfilEntrevistadoDTO.getResistencia();
        Integer velocidade = perfilEntrevistadoDTO.getVelocidade();
        Integer envergaduraEstatura = perfilEntrevistadoDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEntrevistadoDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEntrevistadoDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEntrevistadoDTO.getImc();
        PerfilEntrevistado perfilEntrevistado = new PerfilEntrevistado(agilidade, coordenacaoMotora, flexibilidade,
                forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
        perfilEntrevistado = this.perfilEntrevistadoRepository.save(perfilEntrevistado);
        return perfilEntrevistado;
    }

    @Transactional(readOnly = false)
    public void delete(PerfilEntrevistadoDTO perfilEntrevistadoDTO) {
        this.perfilEntrevistadoRepository.deleteById(perfilEntrevistadoDTO.getId());
    }

    public PerfilEntrevistadoDTO update(PerfilEntrevistadoDTO perfilEntrevistadoDTO) {
        Integer id = perfilEntrevistadoDTO.getId();
        Integer agilidade = perfilEntrevistadoDTO.getAgilidade();
        Integer coordenacaoMotora = perfilEntrevistadoDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilEntrevistadoDTO.getFlexibilidade();
        Integer forca = perfilEntrevistadoDTO.getForca();
        Integer hipertrofia = perfilEntrevistadoDTO.getHipertrofia();
        Integer potencia = perfilEntrevistadoDTO.getPotencia();
        Integer resistencia = perfilEntrevistadoDTO.getResistencia();
        Integer velocidade = perfilEntrevistadoDTO.getVelocidade();
        Integer envergaduraEstatura = perfilEntrevistadoDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilEntrevistadoDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilEntrevistadoDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilEntrevistadoDTO.getImc();
        this.perfilEntrevistadoRepository.update(id, agilidade, coordenacaoMotora, flexibilidade, forca, hipertrofia,
                potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
        PerfilEntrevistado perfilEntrevistado = this.perfilEntrevistadoRepository
                .findById(perfilEntrevistadoDTO.getId()).get();
        perfilEntrevistadoDTO = new PerfilEntrevistadoDTO(perfilEntrevistado);
        return perfilEntrevistadoDTO;
    }
}
