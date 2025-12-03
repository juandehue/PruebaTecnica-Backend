package com.pruebaTecnica.api.service;


import java.util.List;

import com.pruebaTecnica.api.dto.LoginResponseDTO;
import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.dto.UserDTO;
import com.pruebaTecnica.api.entity.ProductEntity;


public interface UserService {

    UserDTO create(UserCreateDTO dto);

    UserDTO get(Long id);

    List<UserDTO> getAllUsers();

    String getUserRole(Long id);

    LoginResponseDTO login(String email, String password);

}
