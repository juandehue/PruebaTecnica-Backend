package com.pruebaTecnica.api.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class HolaMundoController {
    
    @GetMapping("/HolaMundo")
    public ResponseEntity<String> holaMundo() {

        return ResponseEntity.ok().body("Hola mundo!");
    }
    
}
