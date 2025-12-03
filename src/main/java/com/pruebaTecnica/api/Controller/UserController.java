package com.pruebaTecnica.api.controller;

import com.pruebaTecnica.api.dto.LoginRequestDTO;
import com.pruebaTecnica.api.dto.LoginResponseDTO;
import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.dto.UserDTO;
import com.pruebaTecnica.api.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    //Mandar el ID del usuario loggeado como parametro para dar acceso si es admin
    @PostMapping
    public UserDTO create(@RequestBody UserCreateDTO dto) {
        return userService.create(dto);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping()
    public List<UserDTO> getAllUsers() { //agregar de parametro el idRol para verificar 
        
        return userService.getAllUsers();
    }
    

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        return userService.login(request.getEmail(), request.getPassword());
    }

}
