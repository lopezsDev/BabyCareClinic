package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.principal.models.UsuarioModel;
import com.project.principal.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/add")
    public UsuarioModel addUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("/allusers")
    public List<UsuarioModel> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioModel getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public UsuarioModel updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        usuarioModel.setId(id);
        return usuarioService.addUsuario(usuarioModel);
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    @GetMapping("/saludar")
        public String saludar(){
        return "Hola putos";
        }
}

