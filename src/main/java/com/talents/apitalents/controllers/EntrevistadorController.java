package com.talents.apitalents.controllers;

import java.util.List;

import com.talents.apitalents.dtos.entrevista.EntrevistaDTO;
import com.talents.apitalents.dtos.entrevista.EntrevistaInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorUpdateDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteInsertDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteUpdateDTO;
import com.talents.apitalents.services.EntrevistaService;
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

    @Autowired
    private EntrevistaService entrevistaService;

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistadorDTO>> findAll() {
        List<EntrevistadorDTO> entrevistadorDTOs = this.entrevistadorService.findAll();
        return ResponseEntity.ok().body(entrevistadorDTOs);
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadorDTO> create(@RequestBody EntrevistadorInsertDTO entrevistadorInsertDTO) {
        EntrevistadorDTO entrevistadorDTO = this.entrevistadorService.create(entrevistadorInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistadorDTO);
    }

    @GetMapping("/with-email/{email}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadorDTO> findByEmail(@PathVariable String email) {
        EntrevistadorDTO entrevistadorDTO = this.entrevistadorService.findByEmail(email);
        return ResponseEntity.ok().body(entrevistadorDTO);
    }

    @GetMapping("/with-id/{id}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<EntrevistadorDTO> findById(@PathVariable Integer id) {
        EntrevistadorDTO entrevistadorDTO = this.entrevistadorService.findById(id);
        return ResponseEntity.ok().body(entrevistadorDTO);
    }

    @PutMapping
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> update(@RequestBody EntrevistadorUpdateDTO entrevistadorUpdateDTO) {
        this.entrevistadorService.update(entrevistadorUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idEntrevistador}")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> deleteEntrevistador(@PathVariable Integer idEntrevistador) {
        this.entrevistadorService.delete(idEntrevistador);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/entrevistador-esportes")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> create(
            @RequestBody List<EntrevistadorEsporteInsertDTO> entrevistadorEsporteInsertDTOs) {
        this.entrevistadorEsporteService.create(entrevistadorEsporteInsertDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/entrevistador-esportes")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> update(@RequestBody List<EntrevistadorEsporteUpdateDTO> entrevistadorEsporteUpdateDTOs) {
        this.entrevistadorEsporteService.update(entrevistadorEsporteUpdateDTOs);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entrevistador-esportes/{id}")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        this.entrevistadorEsporteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idEntrevistador}/entrevistas")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<EntrevistaDTO>> findEntrevistas(@PathVariable Integer idEntrevistador) {
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByEntrevistador(idEntrevistador);
        return ResponseEntity.ok().body(entrevistaDTOs);
    }

    @PostMapping("/entrevistas")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<EntrevistaDTO> create(@RequestBody EntrevistaInsertDTO entrevistaInsertDTO) {
        EntrevistaDTO entrevistaDTO = this.entrevistaService.create(entrevistaInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaDTO);
    }

    @PutMapping("/entrevistas")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> update(@RequestBody EntrevistaDTO entrevistaDTO) {
        this.entrevistaService.update(entrevistaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entrevistas/{idEntrevista}")
    @Secured({ "ROLE_ADMIN", "ROLE_INTERVIEWER" })
    public ResponseEntity<Object> deleteEntrevista(@PathVariable Integer id) {
        this.entrevistaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
