package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.esporte.EsporteDTO;
import com.talents.apitalents.entities.Esporte;
import com.talents.apitalents.repositories.EsporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EsporteService {

    @Autowired
    private EsporteRepository esporteRepository;

    @Transactional(readOnly = true)
    public List<EsporteDTO> findAll() {
        List<Esporte> esportes = this.esporteRepository.findAll();
        return esportes.stream().map(esporte -> new EsporteDTO(esporte)).collect(Collectors.toList());
    }
}
