package com.pruebaTecnica.api.mapper;

import com.pruebaTecnica.api.dto.UserDTO;
import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserCreateDTO dto) {
        UserEntity u = new UserEntity();
        u.setName(dto.getName());
        u.setLastname(dto.getLastname());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        return u;
    }

    public static UserDTO toDTO(UserEntity u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setLastname(u.getLastname());
        dto.setEmail(u.getEmail());
        dto.setRoleName(u.getRole().getName());
        return dto;
    }
}
