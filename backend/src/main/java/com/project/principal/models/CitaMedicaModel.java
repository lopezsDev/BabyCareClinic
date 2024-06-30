package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

/**
 * Class that represents a medical appointment.
 *
 * @author lopezs.dev
 * @version [1.0]
 */
@Data
@Entity
@Table(name = "citas_medicas")
public class CitaMedicaModel {

    /**
     * Unique identifier for the medical appointment.
     **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    /**
     * Date of the medical appointment.
     */
    @Column(name = "fecha")
    private Date fecha;

    /**
     * Time of the medical appointment.
     */
    @Column(name = "hora")
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente_id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false, referencedColumnName = "id_usuario")
    private UsuarioModel medico_id;

}
