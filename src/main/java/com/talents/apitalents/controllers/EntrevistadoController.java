package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.entrevistado.EntrevistadoDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoInsertDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoUpdateDTO;
import com.talents.apitalents.services.EntrevistadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entrevistados")
public class EntrevistadoController {

    @Autowired
    private EntrevistadoService entrevistadoService;

    @GetMapping
    public ResponseEntity<List<EntrevistadoDTO>> findAll() {
        List<EntrevistadoDTO> entrevistadoDTOs = this.entrevistadoService.findAll();
        return ResponseEntity.ok().body(entrevistadoDTOs);
    }

    @PostMapping
    public ResponseEntity<EntrevistadoDTO> create(@RequestBody EntrevistadoInsertDTO entrevistadoInsertDTO) {
        EntrevistadoDTO entrevistadoDTO = this.entrevistadoService.create(entrevistadoInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistadoDTO);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody EntrevistadoUpdateDTO entrevistadoUpdateDTO) {
        this.entrevistadoService.update(entrevistadoUpdateDTO);
        return ResponseEntity.ok().build();
    }
}
