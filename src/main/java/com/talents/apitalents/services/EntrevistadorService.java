package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.entrevistador.EntrevistadorDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorUpdateDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.Graduacao;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.GraduacaoRepository;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

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

    @Transactional(readOnly = true)
    public EntrevistadorDTO findById(Integer id) {
        Entrevistador entrevistador = this.entrevistadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No data found for id: " + id));
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    @Transactional(readOnly = true)
    public EntrevistadorDTO findByEmail(String email) {
        Entrevistador entrevistador = this.entrevistadorRepository.findByEmail(email);
        if (entrevistador == null) {
            throw new EntityNotFoundException(email);
        }
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    @Transactional(readOnly = false)
    public EntrevistadorDTO create(EntrevistadorInsertDTO entrevistadorInsertDTO) {
        Integer idGraduacao = entrevistadorInsertDTO.getIdGraduacao();
        String nome = entrevistadorInsertDTO.getNome();
        String email = entrevistadorInsertDTO.getEmail();
        String titulacao = entrevistadorInsertDTO.getTitulacao();
        Entrevistador entrevistador = new Entrevistador(nome, email, titulacao);
        Graduacao graduacao = this.graduacaoRepository.findById(idGraduacao)
                .orElseThrow(() -> new EntityNotFoundException(idGraduacao));
        entrevistador.setGraduacao(graduacao);
        entrevistador = this.entrevistadorRepository.save(entrevistador);
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    public void update(EntrevistadorUpdateDTO entrevistadorUpdateDTO) {
        Integer id = entrevistadorUpdateDTO.getId();
        Integer idGraduacao = entrevistadorUpdateDTO.getIdGraduacao();
        String nome = entrevistadorUpdateDTO.getNome();
        String email = entrevistadorUpdateDTO.getEmail();
        String titulacao = entrevistadorUpdateDTO.getTitulacao();
        this.entrevistadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        this.graduacaoRepository.findById(idGraduacao).orElseThrow(() -> new EntityNotFoundException(idGraduacao));
        this.entrevistadorRepository.update(nome, email, titulacao, idGraduacao, id);
    }

    public void delete(Integer idEntrevistador) {
        Entrevistador entrevistador = this.entrevistadorRepository.findById(idEntrevistador)
                .orElseThrow(() -> new EntityNotFoundException(idEntrevistador));
        this.entrevistadorRepository.delete(entrevistador);
    }
}
