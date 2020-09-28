package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dto.EstadoDTO;
import com.talents.apitalents.entities.Estado;
import com.talents.apitalents.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional(readOnly = true)
    public List<EstadoDTO> findAll() {
        List<Estado> estados = this.estadoRepository.findAll();
        return estados.stream().map(estado -> new EstadoDTO(estado)).collect(Collectors.toList());
    }
}
