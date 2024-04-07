package com.project.principal.models;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "Citas_Medicas")
public class CitaMedica {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "fecha")
    private Date fecha;

    @Getter @Setter @Column(name = "hora")
    private Date hora;

    @Getter @Setter @Column(name = "pacienteId")
    private String pacienteId;

    @Getter @Setter @Column(name = "medicoId")
    private String medicoId;
}
