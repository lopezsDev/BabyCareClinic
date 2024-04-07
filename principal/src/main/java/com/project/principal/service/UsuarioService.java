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

    public UsuarioModel addUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public UsuarioModel getUsuarioById(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("No se pudo encontrar el usuario " + id);
        }

    }




    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

