package com.talents.apitalents.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.EntrevistaDTO;
import com.talents.apitalents.dtos.PerfilEntrevistadoDTO;
import com.talents.apitalents.entities.Entrevista;
import com.talents.apitalents.entities.Entrevistado;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.Esporte;
import com.talents.apitalents.entities.PerfilEntrevistado;
import com.talents.apitalents.repositories.EntrevistaRepository;
import com.talents.apitalents.repositories.EntrevistadoRepository;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.EsporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistaService {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Autowired
    private PerfilEntrevistadoService perfilEntrevistadoService;

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Autowired
    private EntrevistadoRepository entrevistadoRepository;

    @Autowired
    private EsporteRepository esporteRepository;

    @Transactional(readOnly = true)
    public List<EntrevistaDTO> findAll() {
        List<Entrevista> entrevistas = this.entrevistaRepository.findAll();
        return entrevistas.stream().map(entrevista -> new EntrevistaDTO(entrevista)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EntrevistaDTO> findByIdEntrevistado(Integer idEntrevistado) {
        Entrevistado entrevistado = new Entrevistado();
        entrevistado.setId(idEntrevistado);
        List<Entrevista> entrevistas = this.entrevistaRepository.findByEntrevistado(entrevistado);
        return entrevistas.stream().map(entrevista -> new EntrevistaDTO(entrevista)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EntrevistaDTO> findByIdEntrevistador(Integer idEntrevistador) {
        Entrevistador entrevistador = new Entrevistador();
        entrevistador.setId(idEntrevistador);
        List<Entrevista> entrevistas = this.entrevistaRepository.findByEntrevistador(entrevistador);
        return entrevistas.stream().map(entrevista -> new EntrevistaDTO(entrevista)).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistaDTO create(EntrevistaDTO entrevistaDTO) {
        Entrevistador entrevistador = this.entrevistadorRepository.getOne(entrevistaDTO.getEntrevistadorDTO().getId());
        Entrevistado entrevistado = this.entrevistadoRepository.getOne(entrevistaDTO.getEntrevistadoDTO().getId());
        Esporte esporte = this.esporteRepository.getOne(entrevistaDTO.getEsporteDTO().getId());
        Entrevista entrevista = new Entrevista(entrevistaDTO.getDataEntrevista(), entrevistado, entrevistador, esporte);
        PerfilEntrevistado perfilEntrevistado = this.perfilEntrevistadoService
                .create(entrevistaDTO.getPerfilEntrevistadoDTO());
        entrevista.setPerfilEntrevistado(perfilEntrevistado);
        entrevista = this.entrevistaRepository.save(entrevista);
        entrevistaDTO = new EntrevistaDTO(entrevista);
        return entrevistaDTO;
    }

    @Transactional(readOnly = false)
    public EntrevistaDTO update(EntrevistaDTO entrevistaDTO) {
        Integer idEntrevista = entrevistaDTO.getId();
        LocalDate dataEntrevista = entrevistaDTO.getDataEntrevista();
        Integer idEntrevistado = entrevistaDTO.getEntrevistadoDTO().getId();
        Integer idEntrevistador = entrevistaDTO.getEntrevistadorDTO().getId();
        Integer idEsporte = entrevistaDTO.getEsporteDTO().getId();
        Integer idPerfilEntrevistado = entrevistaDTO.getPerfilEntrevistadoDTO().getId();
        PerfilEntrevistadoDTO perfilEntrevistadoDTO = entrevistaDTO.getPerfilEntrevistadoDTO();
        perfilEntrevistadoDTO = this.perfilEntrevistadoService.update(perfilEntrevistadoDTO);
        this.entrevistaRepository.update(idEntrevista, dataEntrevista, idEntrevistado, idEntrevistador, idEsporte,
                idPerfilEntrevistado);
        Entrevista entrevista = this.entrevistaRepository.findById(entrevistaDTO.getId()).get();
        entrevistaDTO = new EntrevistaDTO(entrevista);
        return entrevistaDTO;
    }

    @Transactional(readOnly = false)
    public void delete(EntrevistaDTO entrevistaDTO) {
        this.entrevistaRepository.deleteById(entrevistaDTO.getId());
        this.perfilEntrevistadoService.delete(entrevistaDTO.getPerfilEntrevistadoDTO());
    }
}
