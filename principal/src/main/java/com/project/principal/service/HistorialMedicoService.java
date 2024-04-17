package com.project.principal.service;

import java.util.List;

import com.project.principal.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.HistorialMedicoModel;

@Service
public class HistorialMedicoService {

    private final HistorialMedicoRepository historialMedicoRepository;

    @Autowired
    public HistorialMedicoService(HistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }

    public HistorialMedicoModel getHistorialMedico(Long id) {
        return historialMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar el historial médico con id: " + id));
    }
}

