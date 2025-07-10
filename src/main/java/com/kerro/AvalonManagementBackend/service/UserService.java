package com.kerro.AvalonManagementBackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kerro.AvalonManagementBackend.exception.user.UserNotFoundException;
import com.kerro.AvalonManagementBackend.model.User;
import com.kerro.AvalonManagementBackend.dto.UserDTO;
import com.kerro.AvalonManagementBackend.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> obtenerUsuarios(){
        List<User> usuarios = userRepository.findAll();
        if(usuarios.isEmpty()) {
            throw new UserNotFoundException("Usuarios no encontrados");
        }
        return usuarios.stream()
            .map(usuario -> modelMapper.map(usuario, UserDTO.class))
            .collect(Collectors.toList());
    }


    public UserDTO obtenerUsuarioPorId(Long id) {
        User usuario = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(usuario, UserDTO.class);
    }
    
    public UserDTO crearUsuario(UserDTO userDTO) {
        User usuario = modelMapper.map(userDTO, User.class);
        User usuarioCreado = userRepository.save(usuario);
        return modelMapper.map(usuarioCreado, UserDTO.class);
    }

    public UserDTO actualizarUsuario(Long id, UserDTO userDTO) {
        User usuarioExistente = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        
        modelMapper.map(userDTO, usuarioExistente);
        User usuarioActualizado = userRepository.save(usuarioExistente);
        return modelMapper.map(usuarioActualizado, UserDTO.class);
    }

    public void eliminarUsuario(Long id) {
        User usuario = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(usuario);
    }


    public UserDTO obtenerUsuarioPorUsername(String username){
        User usuario = userRepository.findByUsername(username)
           .orElseThrow(() -> new UserNotFoundException(username));
        return modelMapper.map(usuario, UserDTO.class);
    }

    public UserDTO obtenerUsuarioPassword(String username, String password) {
        User usuario = userRepository.findByUsernameAndPassword(username, password)
            .orElseThrow(() -> new UserNotFoundException(username));
        return modelMapper.map(usuario, UserDTO.class);
    }

}
