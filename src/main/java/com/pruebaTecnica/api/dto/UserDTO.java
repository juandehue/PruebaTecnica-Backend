package com.pruebaTecnica.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @Schema(description = "ID del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombre del usuario", example = "Juan")
    private String name;

    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String lastname;

    @Schema(description = "Email del usuario", example = "juan@example.com")
    private String email;

    @Schema(description = "Nombre del rol del usuario", example = "ADMIN")
    private String roleName;
}
