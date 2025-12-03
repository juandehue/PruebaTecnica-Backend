package com.pruebaTecnica.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_logs")
@Getter
@Setter
public class LogProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de acción es obligatorio")
    @Column(nullable = false)
    private String action; 

    @NotNull(message = "El usuario que realizó la acción es obligatorio")
    private Long userId;

    @NotNull(message = "El producto es obligatorio")
    private Long productId;

    @Column(name = "old_value", columnDefinition = "text")
    private String oldValue;

    @Column(name = "new_value", columnDefinition = "text")
    private String newValue;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
