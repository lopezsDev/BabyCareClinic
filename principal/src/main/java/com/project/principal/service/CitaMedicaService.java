package com.project.principal.service;

import java.util.ArrayList;

import com.project.principal.repository.CitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.principal.models.CitaMedica;

@Service
public class CitaMedicaService {
    @Autowired
    private final CitaMedicaRepository citaMedicaRepository;


    public CitaMedicaService(CitaMedicaRepository citaMedicaRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
    }

    public ArrayList<CitaMedica> ListAllCitasMedicas() {
        return (ArrayList<CitaMedica>) citaMedicaRepository.findAll();
    }

    public CitaMedica getCitaMedica(Long id) {
        return citaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar la cita médica con id: " + id));
    }

    public CitaMedica saveCitaMedica(CitaMedica citaMedica) {
        return citaMedicaRepository.save(citaMedica);
    }

    public boolean deleteCitaMedica(Long id) {
        try {
            citaMedicaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }

    }
}

