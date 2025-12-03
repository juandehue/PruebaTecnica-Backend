package com.pruebaTecnica.api.controller;

import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.ProductEntity;
import com.pruebaTecnica.api.service.ProductService;
import com.pruebaTecnica.api.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService  userService;

    private final String RoleErrorMsg =  "Este servicio solamente esta disponible para administradores";

    @PostMapping("/user/{userId}")
    public ResponseEntity<Object> create(@PathVariable Long userId,@RequestBody ProductDTO dto) {

        boolean isAdmin = userService.getUserRole(userId).equals("Admin");

        if (!isAdmin) {
            return ResponseEntity.badRequest().body(RoleErrorMsg);
        }

        return ResponseEntity.ok().body(productService.create(dto));
    }

    
    @PatchMapping("/{id}/user/{userId}")
    public ResponseEntity<Object> update( @PathVariable Long id,
                                          @PathVariable Long userId,
                                          @RequestBody UpdateProductDTO dto ) {

        boolean isAdmin = userService.getUserRole(userId).equals("Admin");

        if (!isAdmin) {
            return ResponseEntity.badRequest().body(RoleErrorMsg);
        }

        return ResponseEntity.ok(productService.update(id, userId, dto));
    
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<Object> delete(@PathVariable Long id,
                                         @PathVariable Long userId) {
        
        boolean isAdmin = userService.getUserRole(userId).equals("Admin");
        
        if (!isAdmin) {
            return ResponseEntity.badRequest().body(RoleErrorMsg);
        }
        
        boolean deleted = productService.delete(id, userId);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/{id}")
    public ProductEntity get(@PathVariable Long id) {

        return productService.get(id);
    }

    @GetMapping("/getAll") 
    public List<ProductEntity> getAll() {
        return productService.getAll();
    }

    @GetMapping("/logs/user/{userId}")
    public ResponseEntity<Object> getAllLogs(@PathVariable Long userId) {
        
        boolean isAdmin = userService.getUserRole(userId).equals("Admin");
        
        if (!isAdmin) {
            return ResponseEntity.badRequest().body(RoleErrorMsg);
        }
    
        return ResponseEntity.ok(productService.getAllLogs());

    }
    


}
