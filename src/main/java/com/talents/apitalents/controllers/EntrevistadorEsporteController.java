package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.EntrevistadorEsporteDTO;
import com.talents.apitalents.services.EntrevistadorEsporteService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/entrevistadoresportes")
public class EntrevistadorEsporteController {

    @Autowired
    private EntrevistadorEsporteService entrevistadorEsporteService;

    @GetMapping("/entrevistador/{idEntrevistador}")
    public ResponseEntity<List<EntrevistadorEsporteDTO>> findByEntrevistador(@PathVariable Integer idEntrevistador) {
        List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs = this.entrevistadorEsporteService
                .findByEntrevistador(idEntrevistador);
        return ResponseEntity.ok().body(entrevistadorEsporteDTOs);
    }

    @PostMapping
    public ResponseEntity<List<EntrevistadorEsporteDTO>> create(
            @RequestBody List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs) {
        entrevistadorEsporteDTOs = this.entrevistadorEsporteService.create(entrevistadorEsporteDTOs);
        return ResponseEntity.ok().body(entrevistadorEsporteDTOs);
    }

    @PutMapping
    public ResponseEntity<EntrevistadorEsporteDTO> update(
            @RequestBody EntrevistadorEsporteDTO entrevistadorEsporteDTO) {
        entrevistadorEsporteDTO = this.entrevistadorEsporteService.update(entrevistadorEsporteDTO);
        return ResponseEntity.ok().body(entrevistadorEsporteDTO);
    }

    @DeleteMapping("/{idEntrevistadorEsporte}")
    public ResponseEntity<EntrevistadorEsporteDTO> delete(@PathVariable Integer idEntrevistadorEsporte) {
        EntrevistadorEsporteDTO entrevistadorEsporteDTO = this.entrevistadorEsporteService
                .delete(idEntrevistadorEsporte);
        return ResponseEntity.ok().body(entrevistadorEsporteDTO);
    }
}
