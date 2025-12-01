package com.pruebaTecnica.api.controller;

import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.ProductEntity;
import com.pruebaTecnica.api.service.ProductService;
import com.pruebaTecnica.api.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService  userService;

    private final String RoleErrorMsg =  "Este servicio solamente esta disponible para administradores";

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProductDTO dto, Long idUser) {
    
        boolean isAdmin = userService.getUserRole(idUser).equals("Admin");
        return isAdmin ? 
            ResponseEntity.ok().body(productService.create(dto)) : 
            ResponseEntity.badRequest().body(RoleErrorMsg);    
    }

    @PatchMapping("/{id}/user/{userId}")
    public ProductEntity update(
            @PathVariable Long id,
            @PathVariable Long userId,
            @RequestBody UpdateProductDTO dto) {
        return productService.update(id, userId, dto);
    }

    @DeleteMapping("/{id}/user/{userId}")
    public boolean delete(
            @PathVariable Long id,
            @PathVariable Long userId) {
        return productService.delete(id, userId);
    }

    @GetMapping("/{id}")
    public ProductEntity get(@PathVariable Long id) {
        return productService.get(id);
    }
}
