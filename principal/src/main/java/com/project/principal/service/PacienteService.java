package com.project.principal.service;

import java.util.List;

import com.project.principal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.Pacientes;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Pacientes> getPacientes() {
        return pacienteRepository.findAll();
    }

    public Pacientes getPaciente(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar el paciente con id: " + id));
    }

    public Pacientes savePaciente(Pacientes pacientes) {
        return pacienteRepository.save(pacientes);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}

