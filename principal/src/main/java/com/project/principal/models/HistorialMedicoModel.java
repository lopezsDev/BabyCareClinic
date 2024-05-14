package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;
/**
 * This class represents a medical history record in the system.
 * @author lopezs.dev
 */
@Data
@Entity
@Table(name = "Historial_Medico")
public class HistorialMedicoModel {

    /**
     * Unique identifier for the medical history record. This field is auto-generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Identifier of the patient associated with this medical history record.
     */
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente_id;

    /**
     * Identifier of the doctor associated with this medical history record.
     */
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private UsuarioModel medico_id;


    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamiento")
    private String tratamiento;

}