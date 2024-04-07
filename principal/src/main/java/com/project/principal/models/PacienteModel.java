package com.project.principal.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Pacientes")
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;
}
