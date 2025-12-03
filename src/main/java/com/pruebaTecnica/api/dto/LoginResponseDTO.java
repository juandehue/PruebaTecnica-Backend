package com.pruebaTecnica.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {

    private Long id;
    private String email;
    private String name;
    private Integer roleId;
    private String roleName;

}
