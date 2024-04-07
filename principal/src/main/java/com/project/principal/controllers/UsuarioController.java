package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.principal.models.UsuarioModel;
import com.project.principal.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioModel addUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioModel getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        usuarioModel.setId(id);
        return usuarioService.saveUsuario(usuarioModel);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}

