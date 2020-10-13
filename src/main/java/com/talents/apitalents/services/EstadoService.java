package com.talents.apitalents.services;

import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.cidade.CidadeDTO;
import com.talents.apitalents.dtos.estado.EstadoDTO;
import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.entities.Estado;
import com.talents.apitalents.repositories.CidadeRepository;
import com.talents.apitalents.repositories.EstadoRepository;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public List<EstadoDTO> findAll() {
        List<Estado> estados = this.estadoRepository.findAll();
        return estados.stream().map(estado -> new EstadoDTO(estado)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CidadeDTO> findCidades(Integer idEstado) {
        Estado estado = this.estadoRepository.findById(idEstado)
                .orElseThrow(() -> new EntityNotFoundException(idEstado));
        List<Cidade> cidades = this.cidadeRepository.findByEstado(estado);
        return cidades.stream().map(cidade -> new CidadeDTO(cidade)).collect(Collectors.toList());
    }
}
