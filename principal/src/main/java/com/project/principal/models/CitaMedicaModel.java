package com.project.principal.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Citas_Medicas")
public class CitaMedicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "pacienteId")
    private String pacienteId;

    @Column(name = "medicoId")
    private String medicoId;
}
