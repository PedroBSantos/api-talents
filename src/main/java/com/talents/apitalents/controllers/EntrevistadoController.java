package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.entrevista.EntrevistaDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoInsertDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoUpdateDTO;
import com.talents.apitalents.services.EntrevistaService;
import com.talents.apitalents.services.EntrevistadoService;

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
@RequestMapping(value = "/entrevistados")
public class EntrevistadoController {

    @Autowired
    private EntrevistadoService entrevistadoService;

    @Autowired
    private EntrevistaService entrevistaService;

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistadoDTO>> findAll() {
        List<EntrevistadoDTO> entrevistadoDTOs = this.entrevistadoService.findAll();
        return ResponseEntity.ok().body(entrevistadoDTOs);
    }

    @GetMapping("/with-email/{email}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadoDTO> findByEmail(@PathVariable String email) {
        EntrevistadoDTO entrevistadoDTO = this.entrevistadoService.findByEmail(email);
        return ResponseEntity.ok().body(entrevistadoDTO);
    }

    @GetMapping("/with-id/{id}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadoDTO> findById(@PathVariable Integer id) {
        EntrevistadoDTO entrevistadoDTO = this.entrevistadoService.findById(id);
        return ResponseEntity.ok().body(entrevistadoDTO);
    }

    @GetMapping("/{idEntrevistado}/entrevistas")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistaDTO>> findEntrevistas(@PathVariable Integer idEntrevistado) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByEntrevistado(idEntrevistado);
        return ResponseEntity.ok().body(entrevistaDTOs);
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadoDTO> create(@RequestBody EntrevistadoInsertDTO entrevistadoInsertDTO) {
        EntrevistadoDTO entrevistadoDTO = this.entrevistadoService.create(entrevistadoInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistadoDTO);
    }

    @PutMapping
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWEE" })
    public ResponseEntity<Object> update(@RequestBody EntrevistadoUpdateDTO entrevistadoUpdateDTO) {
        this.entrevistadoService.update(entrevistadoUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idEntrevistado}")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<Object> delete(@PathVariable Integer idEntrevistado) {
        this.entrevistadoService.delete(idEntrevistado);
        return ResponseEntity.ok().build();
    }
}
