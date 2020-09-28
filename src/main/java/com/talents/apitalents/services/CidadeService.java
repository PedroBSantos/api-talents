package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.CidadeDTO;
import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.repositories.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public List<CidadeDTO> findByIdEstado(Integer idEstado) {
        List<Cidade> cidades = this.cidadeRepository.findByIdEstado(idEstado);
        return cidades.stream().map(cidade -> new CidadeDTO(cidade)).collect(Collectors.toList());
    }
}
