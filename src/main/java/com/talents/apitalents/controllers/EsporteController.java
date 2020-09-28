package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dto.EsporteDTO;
import com.talents.apitalents.services.EsporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esportes")
public class EsporteController {

    @Autowired
    private EsporteService esporteService;

    @GetMapping
    public ResponseEntity<List<EsporteDTO>> findAll() {
        List<EsporteDTO> esporteDTOs = this.esporteService.findAll();
        return ResponseEntity.ok().body(esporteDTOs);
    }
}
