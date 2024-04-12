package com.project.principal.service;

import com.project.principal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.principal.models.PacienteModel;

/**
 * This class provides business logic services for managing patient data.
 */
@Service
public class PacienteService {

    /**
     * The injected PacienteRepository dependency for accessing patient data.
     */
    private final PacienteRepository pacienteRepository;

    /**
     * Constructs a PacienteService instance and autowires the PacienteRepository dependency.
     *
     * @param pacienteRepository The PacienteRepository to be injected.
     */
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    /**
     * Retrieves a patient from the database by their ID.
     *
     * @param id The ID of the patient to retrieve.
     * @return The PacienteModel object representing the found patient, or null if not found.
     * @throws RuntimeException If no patient is found with the specified ID.
     */
    public PacienteModel getPaciente(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar el paciente con id: " + id));
    }

    /**
     * Saves a patient to the database. If the patient exists, it updates the existing record;
     * otherwise, it creates a new record.
     *
     * @param paciente The PacienteModel object representing the patient to save.
     * @return The saved PacienteModel object, including any updated information.
     */
    public PacienteModel savePaciente(PacienteModel paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Deletes a patient from the database by their ID.
     *
     * @param id The ID of the patient to delete.
     */
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}

