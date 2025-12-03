package com.pruebaTecnica.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 30, message = "El apellido debe tener entre 2 y 30 caracteres")
    @Column(nullable = false)
    private String lastname;

    @Size(max = 15, message = "El teléfono no puede exceder 15 caracteres")
    @Pattern(
        regexp = "^[0-9+() -]*$",
        message = "El teléfono solo puede contener números, espacios, +, -, (, )"
    )
    private String phone;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    @Size(max = 50, message = "El correo electrónico no puede exceder 50 caracteres")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @Column(name = "user_active", nullable = false)
    private Boolean userActive = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
