package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.EntrevistadorDTO;
import com.talents.apitalents.dtos.GraduacaoDTO;
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

    @Transactional(readOnly = true)
    public List<EntrevistadorDTO> findAll() {
        List<Entrevistador> entrevistadores = this.entrevistadorRepository.findAll();
        return entrevistadores.stream().map(entrevistador -> new EntrevistadorDTO(entrevistador))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistadorDTO create(EntrevistadorDTO entrevistadorDTO) {
        String nome = entrevistadorDTO.getNome();
        String email = entrevistadorDTO.getEmail();
        String titulacao = entrevistadorDTO.getTitulacao();
        GraduacaoDTO graduacaoDTO = entrevistadorDTO.getGraduacaoDTO();
        Graduacao graduacao = this.graduacaoRepository.getOne(graduacaoDTO.getId());
        Entrevistador entrevistador = new Entrevistador(nome, email, titulacao);
        entrevistador.setGraduacao(graduacao);
        entrevistador = this.entrevistadorRepository.save(entrevistador);
        entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    public EntrevistadorDTO update(EntrevistadorDTO entrevistadorDTO) {
        GraduacaoDTO graduacaoDTO = entrevistadorDTO.getGraduacaoDTO();
        Integer idEntrevistador = entrevistadorDTO.getId();
        Integer idGraduacao = graduacaoDTO.getId();
        String nome = entrevistadorDTO.getNome();
        String email = entrevistadorDTO.getEmail();
        String titulacao = entrevistadorDTO.getTitulacao();
        this.entrevistadorRepository.update(nome, email, titulacao, idGraduacao, idEntrevistador);
        Entrevistador entrevistador = this.entrevistadorRepository.findById(entrevistadorDTO.getId()).get();
        entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }
}
