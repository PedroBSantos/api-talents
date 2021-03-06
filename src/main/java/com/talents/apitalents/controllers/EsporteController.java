package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.esporte.EsporteDTO;
import com.talents.apitalents.services.EsporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/esportes")
public class EsporteController {

    @Autowired
    private EsporteService esporteService;

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EsporteDTO>> findAll() {
        List<EsporteDTO> esporteDTOs = this.esporteService.findAll();
        return ResponseEntity.ok().body(esporteDTOs);
    }
}
