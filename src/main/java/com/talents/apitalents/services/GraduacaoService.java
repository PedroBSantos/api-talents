package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.graduacao.GraduacaoDTO;
import com.talents.apitalents.entities.Graduacao;
import com.talents.apitalents.repositories.GraduacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GraduacaoService {

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @Transactional(readOnly = true)
    public List<GraduacaoDTO> findAll() {
        List<Graduacao> graduacoes = this.graduacaoRepository.findAll();
        return graduacoes.stream().map(graduacao -> new GraduacaoDTO(graduacao)).collect(Collectors.toList());
    }
}
