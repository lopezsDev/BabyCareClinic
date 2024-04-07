package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "Historial_Medico")
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "pacienteId")
    private String pacienteId;

    @Getter @Setter @Column(name = "medicoId")
    private String medicoId;

    @Getter @Setter @Column(name = "diagnostico")
    private String diagnostico;

    @Getter @Setter @Column(name = "tratamiento")
    private String tratamiento;
}
