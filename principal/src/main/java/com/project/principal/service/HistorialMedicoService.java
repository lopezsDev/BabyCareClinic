package com.project.principal.service;

import java.util.List;

import com.project.principal.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.HistorialMedico;

@Service
public class HistorialMedicoService {

    private final HistorialMedicoRepository historialMedicoRepository;

    @Autowired
    public HistorialMedicoService(HistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }

    public List<HistorialMedico> getHistorialesMedicos() {
        return historialMedicoRepository.findAll();
    }

    public HistorialMedico getHistorialMedico(Long id) {
        return historialMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar el historial médico con id: " + id));
    }

    public HistorialMedico saveHistorialMedico(HistorialMedico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    public void deleteHistorialMedico(Long id) {
        historialMedicoRepository.deleteById(id);
    }
}

