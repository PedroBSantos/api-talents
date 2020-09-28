package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.GraduacaoDTO;
import com.talents.apitalents.services.GraduacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/graduacoes")
public class GraduacaoController {

    @Autowired
    private GraduacaoService graduacaoService;

    @GetMapping
    public ResponseEntity<List<GraduacaoDTO>> findAll() {
        List<GraduacaoDTO> graduacaoDTOs = this.graduacaoService.findAll();
        return ResponseEntity.ok().body(graduacaoDTOs);
    }
}
