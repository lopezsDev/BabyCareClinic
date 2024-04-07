package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.principal.models.Pacientes;
import com.project.principal.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Pacientes addPaciente(@RequestBody Pacientes pacientes) {
        return pacienteService.savePaciente(pacientes);
    }

    @GetMapping("/{id}")
    public Pacientes getPaciente(@PathVariable Long id) {
        return pacienteService.getPaciente(id);
    }

    @PutMapping("/{id}")
    public Pacientes updatePaciente(@PathVariable Long id, @RequestBody Pacientes pacientes) {
        pacientes.setId(id);
        return pacienteService.savePaciente(pacientes);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}

