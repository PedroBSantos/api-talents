package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.EstadoDTO;
import com.talents.apitalents.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll() {
        List<EstadoDTO> estadoDTOs = this.estadoService.findAll();
        return ResponseEntity.ok().body(estadoDTOs);
    }
}
