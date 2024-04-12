package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.principal.models.PacienteModel;
import com.project.principal.service.PacienteService;

/**
 * This REST controller handles patient-related API requests, mapping them to appropriate HTTP methods and paths.
 */
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    /**
     * The injected PacienteService dependency for managing patient data.
     */
    private final PacienteService pacienteService;

    /**
     * Constructs a PacienteController instance and autowires the PacienteService dependency.
     *
     * @param pacienteService The PacienteService to be injected.
     */
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /**
     * Creates a new patient record.
     *
     * @param pacienteModel The PacienteModel object representing the new patient data.
     * @return The saved PacienteModel object, including any generated identifiers.
     */
    @PostMapping
    public PacienteModel addPaciente(@RequestBody PacienteModel pacienteModel) {
        return pacienteService.savePaciente(pacienteModel);
    }

    /**
     * Retrieves a patient record based on their ID.
     *
     * @param id The ID of the patient to retrieve.
     * @return The PacienteModel object representing the found patient, or null if not found.
     */
    @GetMapping("/{id}")
    public PacienteModel getPaciente(@PathVariable Long id) {
        return pacienteService.getPaciente(id);
    }

    /**
     * Updates an existing patient record.
     *
     * @param id The ID of the patient to update.
     * @param pacienteModel The updated PacienteModel object containing the new patient data.
     * @return The updated PacienteModel object, reflecting the changes made.
     */
    @PutMapping("/{id}")
    public PacienteModel updatePaciente(@PathVariable Long id, @RequestBody PacienteModel pacienteModel) {
        pacienteModel.setId(id);
        return pacienteService.savePaciente(pacienteModel);
    }

    /**
     * Deletes a patient record by their ID.
     *
     * @param id The ID of the patient to delete.
     */
    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}


