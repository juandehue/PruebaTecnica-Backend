package com.pruebaTecnica.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    @Schema(description = "SKU del producto", example = "SKU-123")
    @NotBlank(message = "El SKU es obligatorio")
    @Size(max = 50)
    private String sku;

    @Schema(description = "Nombre del producto", example = "Laptop Dell")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String name;

    @Schema(description = "Precio del producto", example = "15999.99")
    @NotNull(message = "El precio es obligatorio")
    private BigDecimal price;

    @Schema(description = "Marca del producto", example = "Dell")
    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 50)
    private String brand;

    @Schema(description = "Descripción del producto", example = "Laptop con 16GB RAM y 512GB SSD")
    @Size(max = 500)
    private String description;
}
