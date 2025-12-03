package com.pruebaTecnica.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("v1/api")
public class HolaMundoController {
    
    @GetMapping("/HolaMundo")
    public ResponseEntity<String> holaMundo() {

        return ResponseEntity.ok().body("Hola mundo!");
    }
    
}
