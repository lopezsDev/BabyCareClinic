package com.project.principal.service;

import java.util.List;
import java.util.Optional;

import com.project.principal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.Usuarios;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> getUsuarios() {
        return usuarioRepository.findAll();
    }

    
    public Usuarios getUsuario(Long id) {
        Optional<Usuarios> usuarios =  usuarioRepository.findById(id);
        if (usuarios.isPresent()) {
            return usuarios.get();
        } else {
            throw new RuntimeException("No se pudo encontrar el usuario " + id);
        }

    }

    public Usuarios saveUsuario(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

