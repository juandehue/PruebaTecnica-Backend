package com.pruebaTecnica.api.controller;

import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.dto.UserDTO;
import com.pruebaTecnica.api.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public UserDTO create(@RequestBody UserCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return service.get(id);
    }
}
