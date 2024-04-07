package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Historial_Medico")
public class HistorialMedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pacienteId")
    private String pacienteId;

    @Column(name = "medicoId")
    private String medicoId;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamiento")
    private String tratamiento;
}