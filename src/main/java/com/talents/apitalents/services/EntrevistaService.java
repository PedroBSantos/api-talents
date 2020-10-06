package com.talents.apitalents.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.entrevista.EntrevistaDTO;
import com.talents.apitalents.dtos.entrevista.EntrevistaInsertDTO;
import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.dtos.perfil.PerfilInsertDTO;
import com.talents.apitalents.entities.Entrevista;
import com.talents.apitalents.entities.Entrevistado;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.Esporte;
import com.talents.apitalents.entities.PerfilEntrevistado;
import com.talents.apitalents.repositories.EntrevistaRepository;
import com.talents.apitalents.repositories.EntrevistadoRepository;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.EsporteRepository;
import com.talents.apitalents.repositories.PerfilEntrevistadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistaService {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Autowired
    private EsporteRepository esporteRepository;

    @Autowired
    private EntrevistadoRepository entrevistadoRepository;

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Autowired
    private PerfilEntrevistadoRepository perfilEntrevistadoRepository;

    @Transactional(readOnly = true)
    public List<EntrevistaDTO> findByEntrevistado(Integer idEntrevistado) {
        Entrevistado entrevistado = this.entrevistadoRepository.getOne(idEntrevistado);
        List<Entrevista> entrevistas = this.entrevistaRepository.findByEntrevistado(entrevistado);
        return entrevistas.stream().map(entrevista -> new EntrevistaDTO(entrevista)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EntrevistaDTO> findByEntrevistador(Integer idEntrevistador) {
        Entrevistador entrevistador = this.entrevistadorRepository.getOne(idEntrevistador);
        List<Entrevista> entrevistas = this.entrevistaRepository.findByEntrevistador(entrevistador);
        return entrevistas.stream().map(entrevista -> new EntrevistaDTO(entrevista)).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistaDTO create(EntrevistaInsertDTO entrevistaInsertDTO) {
        Integer idEntrevistado = entrevistaInsertDTO.getIdEntrevistado();
        Integer idEntrevistador = entrevistaInsertDTO.getIdEntrevistador();
        Integer idEsporte = entrevistaInsertDTO.getIdEsporte();
        LocalDate dataEntrevista = entrevistaInsertDTO.getDataEntrevista();
        PerfilInsertDTO perfilInsertDTO = entrevistaInsertDTO.getPerfilEntrevistado();
        Esporte esporte = this.esporteRepository.getOne(idEsporte);
        Entrevistador entrevistador = this.entrevistadorRepository.getOne(idEntrevistador);
        Entrevistado entrevistado = this.entrevistadoRepository.getOne(idEntrevistado);
        Entrevista entrevista = new Entrevista(dataEntrevista, entrevistado, entrevistador, esporte);
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
        PerfilEntrevistado perfilEntrevistado = new PerfilEntrevistado(agilidade, coordenacaoMotora, flexibilidade,
                forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura, comprPernasEstatura,
                alturaTroncoCefalicaEstatura, imc);
        perfilEntrevistado = this.perfilEntrevistadoRepository.save(perfilEntrevistado);
        entrevista.setPerfilEntrevistado(perfilEntrevistado);
        entrevista = this.entrevistaRepository.save(entrevista);
        EntrevistaDTO entrevistaDTO = new EntrevistaDTO(entrevista);
        return entrevistaDTO;
    }

    public void update(EntrevistaDTO entrevistaDTO) {
        Integer id = entrevistaDTO.getId();
        Integer idEntrevistado = entrevistaDTO.getIdEntrevistado();
        Integer idEntrevistador = entrevistaDTO.getIdEntrevistador();
        Integer idEsporte = entrevistaDTO.getIdEsporte();
        LocalDate dataEntrevista = entrevistaDTO.getDataEntrevista();
        PerfilDTO perfilEntrevistado = entrevistaDTO.getPerfilEntrevistadoDTO();
        this.entrevistaRepository.update(id, dataEntrevista, idEntrevistado, idEntrevistador, idEsporte,
                perfilEntrevistado.getId());
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
        this.perfilEntrevistadoRepository.update(perfilEntrevistado.getId(), agilidade, coordenacaoMotora,
                flexibilidade, forca, hipertrofia, potencia, resistencia, velocidade, envergaduraEstatura,
                comprPernasEstatura, alturaTroncoCefalicaEstatura, imc);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id) {
        this.entrevistaRepository.deleteById(id);
    }
}
