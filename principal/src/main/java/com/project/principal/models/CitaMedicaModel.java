package com.project.principal.models;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.*;
import lombok.Data;
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

    /**
     * Identifier of the patient associated with the appointment.
     */
    @Column(name = "paciente_id")
    private String pacienteId;

    /**
     * Identifier of the doctor associated with the appointment.
     */
    @Column(name = "medicoI_id")
    private String medicoId;
}
