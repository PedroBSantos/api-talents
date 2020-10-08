package com.talents.apitalents.controllers;

import com.talents.apitalents.dtos.user.UserDTO;
import com.talents.apitalents.dtos.user.UserInsertDTO;
import com.talents.apitalents.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserInsertDTO userInsertDTO) {
        UserDTO userDTO = this.userService.create(userInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }
}
