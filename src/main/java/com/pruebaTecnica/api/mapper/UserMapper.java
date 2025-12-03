package com.pruebaTecnica.api.mapper;

import com.pruebaTecnica.api.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

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

    public static List<UserDTO> toDTOList(List<UserEntity> users) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity user : users) {
            dtoList.add(toDTO(user));
        }
        return dtoList;
    }

}
