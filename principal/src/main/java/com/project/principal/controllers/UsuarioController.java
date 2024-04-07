package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.principal.models.Usuarios;
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
    public Usuarios addUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuarios getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuarios updateUsuario(@PathVariable Long id, @RequestBody Usuarios usuarios) {
        usuarios.setId(id);
        return usuarioService.saveUsuario(usuarios);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}

