package com.project.principal.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This class represents a patient entity.
 *  @author lopezs.dev
 *  * @version [1.0]
 */
@Data
@Entity
@Table(name = "Pacientes")
public class PacienteModel {

    /**
     * The unique identifier of the patient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The patient's first name.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * The patient's last name.
     */
    @Column(name = "apellido")
    private String apellido;

    /**
     * The patient's date of birth.
     */
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    /**
     * The patient's gender.
     */
    @Column(name = "genero")
    private String genero;

    /**
     * The patient's address.
     */
    @Column(name = "direccion")
    private String direccion;

    /**
     * The patient's identification number.
     */
    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;

    @ManyToMany
    @JoinColumn(name = "medico_id")
    private UsuarioModel medico;

    @OneToMany(mappedBy = "paciente")
    private List<CitaMedicaModel> citasMedicas;
}
