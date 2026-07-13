package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return usuarioRepository.save(nuevoUsuario);
    }

    
}
