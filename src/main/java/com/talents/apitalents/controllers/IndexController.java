package com.talents.apitalents.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("api-talents");
    }
}
