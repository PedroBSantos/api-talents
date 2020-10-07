package com.talents.apitalents.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/userinfo")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<UserDetails> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok().body(userDetails);
    }
}
