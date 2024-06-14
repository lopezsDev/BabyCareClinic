package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * This class represents an Usuario (User) entity within the application.
 * It maps to the `usuarios` table in the database and holds essential user information.
 *
 * @author LopezS7
 * @since 8/4/2024
 */
@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    /**
     * The unique identifier of the user.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The user's first name.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * The user's last name.
     */
    @Column(name = "apellido")
    private String apellido;

    /**
     * The user's email address.
     */
    @Column(name = "email")
    private String email;

    /**
     * The user's password (hashed and secured).
     */
    @Column(name = "password")
    private String password;

    /**
     * The user's role within the application (e.g., ADMINISTRADOR, USUARIO).
     */
    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "medico_id")
    private List<HistorialMedicoModel> historialMedico;

    @OneToMany(mappedBy = "medico_id")
    private List<CitaMedicaModel> citaMedica;

}

