package com.project.principal.service;

import java.util.List;
import java.util.Optional;

import com.project.principal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.UsuarioModel;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarioRepository.findAll();
    }

    
    public UsuarioModel getUsuario(Long id) {
        Optional<UsuarioModel> usuarios =  usuarioRepository.findById(id);
        if (usuarios.isPresent()) {
            return usuarios.get();
        } else {
            throw new RuntimeException("No se pudo encontrar el usuario " + id);
        }

    }

    public UsuarioModel saveUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

