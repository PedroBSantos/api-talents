package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.cidade.CidadeDTO;
import com.talents.apitalents.dtos.estado.EstadoDTO;
import com.talents.apitalents.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EstadoDTO>> findAll() {
        List<EstadoDTO> estadoDTOs = this.estadoService.findAll();
        return ResponseEntity.ok().body(estadoDTOs);
    }

    @GetMapping("/{uf}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EstadoDTO> findByUf(@PathVariable String uf) {
        EstadoDTO estadoDTO = this.estadoService.findByUF(uf);
        return ResponseEntity.ok().body(estadoDTO);
    }

    @GetMapping("/{idEstado}/cidades")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer idEstado) {
        List<CidadeDTO> cidadeDTOs = this.estadoService.findCidades(idEstado);
        return ResponseEntity.ok().body(cidadeDTOs);
    }
}
