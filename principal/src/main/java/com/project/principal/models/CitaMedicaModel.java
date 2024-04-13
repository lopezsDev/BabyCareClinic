package com.project.principal.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas_medicas")
public class CitaMedicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "paciente_id")
    private String pacienteId;

    @Column(name = "medicoI_id")
    private String medicoId;
}
