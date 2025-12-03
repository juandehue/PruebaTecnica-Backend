package com.pruebaTecnica.api.service.impl;

import com.pruebaTecnica.api.dto.LoginResponseDTO;
import com.pruebaTecnica.api.dto.UserCreateDTO;
import com.pruebaTecnica.api.dto.UserDTO;
import com.pruebaTecnica.api.entity.RoleEntity;
import com.pruebaTecnica.api.entity.UserEntity;
import com.pruebaTecnica.api.mapper.UserMapper;
import com.pruebaTecnica.api.repository.RoleRepository;
import com.pruebaTecnica.api.repository.UserRepository;
import com.pruebaTecnica.api.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDTO create(UserCreateDTO dto) {

        RoleEntity role = roleRepository.findById(dto.getRoleId()).orElse(null);
        if (role == null) return null;

        UserEntity user = UserMapper.toEntity(dto);
        user.setRole(role);
        user = userRepository.save(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO get(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) return null;

        return UserMapper.toDTO(user);
    }

    
    //Crear para traer todos los usuarios y no solo por ID
    @Override
    public List<UserDTO> getAllUsers(){

        List<UserEntity> users = userRepository.findAll();

        return UserMapper.toDTOList(users);
    }
    
    
    @Override
    public String getUserRole(Long id){
        UserEntity user = userRepository.findById(id).orElse(null);

        return user.getRole().getName();
    }

    public LoginResponseDTO login(String email, String password) {
        UserEntity user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new LoginResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getName(),
            user.getRole().getId(),
            user.getRole().getName()    
        );
    }

}
