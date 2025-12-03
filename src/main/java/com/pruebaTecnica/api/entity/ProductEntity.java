package com.pruebaTecnica.api.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El SKU es obligatorio")
    @Size(max = 100, message = "El SKU no puede exceder 100 caracteres")
    @Pattern(
        regexp = "^[A-Za-z0-9_-]+$",
        message = "El SKU solo puede contener letras, números, guiones y guiones bajos"
    )
    @Column(nullable = false, unique = true)
    private String sku;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 2, max = 255, message = "El nombre debe tener entre 2 y 255 caracteres")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.00", message = "El precio no puede ser negativo")
    @Digits(integer = 12, fraction = 2, message = "El precio debe tener hasta 12 enteros y 2 decimales")
    @Column(nullable = false)
    private BigDecimal price;

    @Size(max = 255, message = "La marca no puede exceder 255 caracteres")
    private String brand;

    @Size(max = 2000, message = "La descripción no puede exceder 2000 caracteres")
    @Column(columnDefinition = "text")
    private String description;
}
