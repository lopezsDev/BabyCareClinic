package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;
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
    private String nombre;

    /**
     * The user's last name.
     */
    private String apellido;

    /**
     * The user's email address.
     */
    private String email;

    /**
     * The user's password (hashed and secured).
     */
    private String password;

    /**
     * The user's role within the application (e.g., ADMINISTRADOR, USUARIO).
     */
    private String rol;
}

