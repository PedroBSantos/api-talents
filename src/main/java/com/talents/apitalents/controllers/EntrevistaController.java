package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.entrevista.EntrevistaDTO;
import com.talents.apitalents.dtos.entrevista.EntrevistaInsertDTO;
import com.talents.apitalents.services.EntrevistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entrevistas")
public class EntrevistaController {

    @Autowired
    private EntrevistaService entrevistaService;

    @GetMapping("/entrevistadores/{idEntrevistador}")
    @Secured({ "ROLE_ENTREVISTADOR" })
    public ResponseEntity<List<EntrevistaDTO>> findByEntrevistador(@PathVariable Integer idEntrevistador) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByEntrevistador(idEntrevistador);
        return ResponseEntity.ok().body(entrevistaDTOs);
    }

    @GetMapping("/entrevistados/{idEntrevistado}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistaDTO>> findByEntrevistado(@PathVariable Integer idEntrevistado) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByEntrevistado(idEntrevistado);
        return ResponseEntity.ok().body(entrevistaDTOs);
    }

    @PostMapping
    @Secured({ "ROLE_ENTREVISTADOR" })
    public ResponseEntity<EntrevistaDTO> create(@RequestBody EntrevistaInsertDTO entrevistaInsertDTO) {
        EntrevistaDTO entrevistaDTO = this.entrevistaService.create(entrevistaInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaDTO);
    }

    @PutMapping
    @Secured({ "ROLE_ENTREVISTADOR" })
    public ResponseEntity<Object> update(@RequestBody EntrevistaDTO entrevistaDTO) {
        this.entrevistaService.update(entrevistaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Secured({ "ROLE_ENTREVISTADOR" })
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        this.entrevistaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
