package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.principal.models.PacienteModel;
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
    public PacienteModel addPaciente(@RequestBody PacienteModel pacienteModel) {
        return pacienteService.savePaciente(pacienteModel);
    }

    @GetMapping("/{id}")
    public PacienteModel getPaciente(@PathVariable Long id) {
        return pacienteService.getPaciente(id);
    }

    @PutMapping("/{id}")
    public PacienteModel updatePaciente(@PathVariable Long id, @RequestBody PacienteModel pacienteModel) {
        pacienteModel.setId(id);
        return pacienteService.savePaciente(pacienteModel);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}

