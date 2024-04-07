package com.project.principal.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "Pacientes")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Getter @Setter @Column(name = "genero")
    private String genero;

    @Getter @Setter @Column(name = "direccion")
    private String direccion;

    @Getter @Setter @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;
}
