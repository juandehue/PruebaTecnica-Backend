package com.pruebaTecnica.api.service;


import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.dto.UserDTO;


public interface UserService {

    UserDTO create(UserCreateDTO dto);

    UserDTO get(Long id);

    String getUserRole(Long id);

}
