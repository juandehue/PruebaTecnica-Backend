package com.pruebaTecnica.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    @Schema(description = "Nombre del usuario", example = "Juan")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 30)
    private String name;

    @Schema(description = "Apellido del usuario", example = "Pérez")
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 30)
    private String lastname;

    @Schema(description = "Email del usuario", example = "juan@example.com")
    @Email(message = "Debe ser un email válido")
    @NotBlank(message = "El email es obligatorio")
    @Size(max = 50)
    private String email;

    @Schema(description = "Contraseña del usuario", example = "password123")
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 100)
    private String password;

    @Schema(description = "ID del rol del usuario", example = "1")
    @NotNull(message = "El rol es obligatorio")
    private Integer roleId;

}
