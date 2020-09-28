package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.EntrevistadorDTO;
import com.talents.apitalents.services.EntrevistadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrevistadores")
public class EntrevistadorController {

    @Autowired
    private EntrevistadorService entrevistadorService;

    @GetMapping
    public ResponseEntity<List<EntrevistadorDTO>> findAll() {
        List<EntrevistadorDTO> entrevistadorDTOs = this.entrevistadorService.findAll();
        return ResponseEntity.ok().body(entrevistadorDTOs);
    }

    @PostMapping
    public ResponseEntity<EntrevistadorDTO> create(@RequestBody EntrevistadorDTO entrevistadorDTO) {
        entrevistadorDTO = this.entrevistadorService.create(entrevistadorDTO);
        return ResponseEntity.ok().body(entrevistadorDTO);
    }

    @PutMapping
    public ResponseEntity<EntrevistadorDTO> update(@RequestBody EntrevistadorDTO entrevistadorDTO) {
        entrevistadorDTO = this.entrevistadorService.update(entrevistadorDTO);
        return ResponseEntity.ok().body(entrevistadorDTO);
    }

    // @DeleteMapping("/{idEntrevistador}")
    // public ResponseEntity<EntrevistadorDTO> delete(@PathVariable Integer idEntrevistador) {
    //     EntrevistadorDTO entrevistadorDTO = this.entrevistadorService.delete(idEntrevistador);
    //     return ResponseEntity.ok().body(entrevistadorDTO);
    // }
}
