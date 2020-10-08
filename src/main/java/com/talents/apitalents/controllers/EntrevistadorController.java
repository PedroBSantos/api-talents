package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.entrevistador.EntrevistadorDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorUpdateDTO;
import com.talents.apitalents.services.EntrevistadorEsporteService;
import com.talents.apitalents.services.EntrevistadorService;

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
@RequestMapping(value = "/entrevistadores")
public class EntrevistadorController {

    @Autowired
    private EntrevistadorService entrevistadorService;

    @Autowired
    private EntrevistadorEsporteService entrevistadorEsporteService;

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistadorDTO>> findAll() {
        List<EntrevistadorDTO> entrevistadorDTOs = this.entrevistadorService.findAll();
        return ResponseEntity.ok().body(entrevistadorDTOs);
    }

    @PostMapping
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<EntrevistadorDTO> create(@RequestBody EntrevistadorInsertDTO entrevistadorInsertDTO) {
        EntrevistadorDTO entrevistadorDTO = this.entrevistadorService.create(entrevistadorInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistadorDTO);
    }

    @PutMapping
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> update(@RequestBody EntrevistadorUpdateDTO entrevistadorUpdateDTO) {
        this.entrevistadorService.update(entrevistadorUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entrevistadoresportes/{id}")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        this.entrevistadorEsporteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
