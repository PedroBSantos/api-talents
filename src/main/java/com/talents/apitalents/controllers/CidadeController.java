package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.CidadeDTO;
import com.talents.apitalents.services.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<List<CidadeDTO>> findByEstado(@PathVariable Integer idEstado) {
        List<CidadeDTO> cidadeDTOs = this.cidadeService.findByIdEstado(idEstado);
        return ResponseEntity.ok().body(cidadeDTOs);
    }
}
