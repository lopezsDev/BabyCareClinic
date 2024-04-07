package com.project.principal.models;

import jakarta.persistence.*;
import lombok.Data;
@Data@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String rol;
}
