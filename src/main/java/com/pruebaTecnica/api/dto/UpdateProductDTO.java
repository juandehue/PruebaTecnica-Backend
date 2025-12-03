package com.pruebaTecnica.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductDTO {

    @Schema(description = "Nuevo nombre del producto", example = "Laptop Dell XPS")
    private String name;

    @Schema(description = "Nuevo precio del producto", example = "17999.99")
    private BigDecimal price;

    @Schema(description = "Nueva marca del producto", example = "Dell")
    private String brand;

    @Schema(description = "Nueva descripción del producto", example = "Laptop actualizada con mejores especificaciones")
    private String description;
}
