package com.pruebaTecnica.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre del rol debe tener entre 3 y 20 caracteres")
    @Pattern(
        regexp = "^[A-Za-z_]+$",
        message = "El nombre del rol solo puede contener letras y guiones bajos"
    )
    @Column(nullable = false, unique = true)
    private String name;
}
