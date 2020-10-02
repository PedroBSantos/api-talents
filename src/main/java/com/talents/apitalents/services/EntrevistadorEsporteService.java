package com.talents.apitalents.services;

import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteInsertDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteUpdateDTO;
import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.dtos.perfil.PerfilInsertDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.EntrevistadorEsporte;
import com.talents.apitalents.entities.Esporte;
import com.talents.apitalents.entities.PerfilEsportistaCustom;
import com.talents.apitalents.repositories.EntrevistadorEsporteRepository;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.EsporteRepository;
import com.talents.apitalents.repositories.PerfilEsportistaCustomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistadorEsporteService {

    @Autowired
    private EntrevistadorEsporteRepository entrevistadorEsporteRepository;

    @Autowired
    private PerfilEsportistaCustomRepository perfilEsportistaCustomRepository;

    @Autowired
    private EsporteRepository esporteRepository;

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Transactional(readOnly = false)
    public EntrevistadorEsporte create(EntrevistadorEsporteInsertDTO entrevistadorEsporteInsertDTO) {
        String abrangencia = entrevistadorEsporteInsertDTO.getAbrangencia();
        Integer idEsporte = entrevistadorEsporteInsertDTO.getIdEsporte();
        Integer idEntrevistador = entrevistadorEsporteInsertDTO.getIdEntrevistador();
        Integer tempoExpertise = entrevistadorEsporteInsertDTO.getTempoExpertise();
        PerfilInsertDTO perfilInsertDTO = entrevistadorEsporteInsertDTO.getPerfilInsertDTO();
        Integer agilidade = perfilInsertDTO.getAgilidade();
        Integer coordenacaoMotora = perfilInsertDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilInsertDTO.getFlexibilidade();
        Integer forca = perfilInsertDTO.getForca();
        Integer hipertrofia = perfilInsertDTO.getHipertrofia();
        Integer potencia = perfilInsertDTO.getPotencia();
        Integer resistencia = perfilInsertDTO.getResistencia();
        Integer velocidade = perfilInsertDTO.getVelocidade();
        Integer envergaduraEstatura = perfilInsertDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilInsertDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilInsertDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilInsertDTO.getImc();
        PerfilEsportistaCustom perfilEsportistaCustom = new PerfilEsportistaCustom(agilidade, coordenacaoMotora,
                flexibilidade, forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura,
                comprPernasEstatura, alturaTroncoCefalicaEstatura, imc);
        perfilEsportistaCustom = this.perfilEsportistaCustomRepository.save(perfilEsportistaCustom);
        Esporte esporte = this.esporteRepository.getOne(idEsporte);
        Entrevistador entrevistador = this.entrevistadorRepository.getOne(idEntrevistador);
        EntrevistadorEsporte entrevistadorEsporte = new EntrevistadorEsporte(entrevistador, esporte, abrangencia,
                tempoExpertise, perfilEsportistaCustom);
        entrevistadorEsporte = this.entrevistadorEsporteRepository.save(entrevistadorEsporte);
        return entrevistadorEsporte;
    }

    @Transactional(readOnly = false)
    public void update(EntrevistadorEsporteUpdateDTO entrevistadorEsporteUpdateDTO) {
        Integer id = entrevistadorEsporteUpdateDTO.getId();
        Integer tempoExpertise = entrevistadorEsporteUpdateDTO.getTempoExpertise();
        String abrangencia = entrevistadorEsporteUpdateDTO.getAbrangencia();
        Integer idEsporte = entrevistadorEsporteUpdateDTO.getIdEsporte();
        PerfilDTO perfilDTO = entrevistadorEsporteUpdateDTO.getPerfilDTO();
        Integer idPerfil = perfilDTO.getId();
        Integer agilidade = perfilDTO.getAgilidade();
        Integer coordenacaoMotora = perfilDTO.getCoordenacaoMotora();
        Integer flexibilidade = perfilDTO.getFlexibilidade();
        Integer forca = perfilDTO.getForca();
        Integer hipertrofia = perfilDTO.getHipertrofia();
        Integer potencia = perfilDTO.getPotencia();
        Integer resistencia = perfilDTO.getResistencia();
        Integer velocidade = perfilDTO.getVelocidade();
        Integer envergaduraEstatura = perfilDTO.getEnvergaduraEstatura();
        Integer comprPernasEstatura = perfilDTO.getComprPernasEstatura();
        Integer alturaTroncoCefalicaEstatura = perfilDTO.getAlturaTroncoCefalicaEstatura();
        Integer imc = perfilDTO.getImc();
        this.perfilEsportistaCustomRepository.update(idPerfil, agilidade, coordenacaoMotora, flexibilidade, forca,
                hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
        this.entrevistadorEsporteRepository.update(id, abrangencia, tempoExpertise, idPerfil, idEsporte);
    }

    @Transactional(readOnly = false)
    public EntrevistadorEsporteDTO delete(Integer id) {
        EntrevistadorEsporte entrevistadorEsporte = this.entrevistadorEsporteRepository.findById(id).get();
        this.entrevistadorEsporteRepository.deleteById(id);
        EntrevistadorEsporteDTO entrevistadorEsporteDTO = new EntrevistadorEsporteDTO(entrevistadorEsporte);
        return entrevistadorEsporteDTO;
    }
}
