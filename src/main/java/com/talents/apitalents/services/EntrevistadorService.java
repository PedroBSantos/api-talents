package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.entrevistador.EntrevistadorDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorUpdateDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteInsertDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteUpdateDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.Graduacao;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.GraduacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistadorService {

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @Autowired
    private EntrevistadorEsporteService entrevistadorEsporteService;

    @Transactional(readOnly = true)
    public List<EntrevistadorDTO> findAll() {
        List<Entrevistador> entrevistadores = this.entrevistadorRepository.findAll();
        return entrevistadores.stream().map(entrevistador -> new EntrevistadorDTO(entrevistador))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistadorDTO create(EntrevistadorInsertDTO entrevistadorInsertDTO) {
        Integer idGraduacao = entrevistadorInsertDTO.getIdGraduacao();
        String nome = entrevistadorInsertDTO.getNome();
        String email = entrevistadorInsertDTO.getEmail();
        String titulacao = entrevistadorInsertDTO.getTitulacao();
        Entrevistador entrevistador = new Entrevistador(nome, email, titulacao);
        Graduacao graduacao = this.graduacaoRepository.getOne(idGraduacao);
        entrevistador.setGraduacao(graduacao);
        entrevistador = this.entrevistadorRepository.save(entrevistador);
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        for (EntrevistadorEsporteInsertDTO entrevistadorEsporteInsertDTO : entrevistadorInsertDTO
                .getEntrevistadorEsporteInsertDTOs()) {
            entrevistadorEsporteInsertDTO.setIdEntrevistador(entrevistador.getId());
            var entrevistadorEsporteDTO = this.entrevistadorEsporteService.create(entrevistadorEsporteInsertDTO);
            entrevistadorDTO.getEntrevistadorEsporteDTOs().add(entrevistadorEsporteDTO);
        }
        return entrevistadorDTO;
    }

    public void update(EntrevistadorUpdateDTO entrevistadorUpdateDTO) {
        Integer id = entrevistadorUpdateDTO.getId();
        Integer idGraduacao = entrevistadorUpdateDTO.getIdGraduacao();
        String nome = entrevistadorUpdateDTO.getNome();
        String email = entrevistadorUpdateDTO.getEmail();
        String titulacao = entrevistadorUpdateDTO.getTitulacao();
        this.entrevistadorRepository.update(nome, email, titulacao, idGraduacao, id);
        for (EntrevistadorEsporteUpdateDTO entrevistadorEsporteUpdateDTO : entrevistadorUpdateDTO
                .getEntrevistadorEsporteUpdateDTOs()) {
            this.entrevistadorEsporteService.update(entrevistadorEsporteUpdateDTO);
        }
    }
}
