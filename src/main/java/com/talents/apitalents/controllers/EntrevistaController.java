package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.EntrevistaDTO;
import com.talents.apitalents.services.EntrevistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrevistas")
public class EntrevistaController {

    @Autowired
    private EntrevistaService entrevistaService;

    @GetMapping("/entrevistado/{idEntrevistado}")
    public ResponseEntity<List<EntrevistaDTO>> findByEntrevistado(@PathVariable Integer idEntrevistado) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByIdEntrevistado(idEntrevistado);
        return ResponseEntity.status(HttpStatus.FOUND).body(entrevistaDTOs);
    }

    @GetMapping("/entrevistador/{idEntrevistador}")
    public ResponseEntity<List<EntrevistaDTO>> findByEntrevistador(@PathVariable Integer idEntrevistador) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByIdEntrevistador(idEntrevistador);
        return ResponseEntity.status(HttpStatus.FOUND).body(entrevistaDTOs);
    }

    @PostMapping
    public ResponseEntity<EntrevistaDTO> create(@RequestBody EntrevistaDTO entrevistaDTO) {
        entrevistaDTO = this.entrevistaService.create(entrevistaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaDTO);
    }

    @PutMapping
    public ResponseEntity<EntrevistaDTO> update(@RequestBody EntrevistaDTO entrevistaDTO) {
        entrevistaDTO = this.entrevistaService.update(entrevistaDTO);
        return ResponseEntity.ok().body(entrevistaDTO);
    }

    @DeleteMapping("/entrevista/{idEntrevista}")
    public ResponseEntity<EntrevistaDTO> delete(@PathVariable Integer idEntrevista) {
        EntrevistaDTO entrevistaDTO = this.entrevistaService.delete(idEntrevista);
        return ResponseEntity.ok().body(entrevistaDTO);
    }
}
