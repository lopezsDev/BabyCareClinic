package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.principal.models.UsuarioModel;
import com.project.principal.service.UsuarioService;

/**
 * This class defines the REST API endpoints for managing Usuario (User) entities within the application.
 * It utilizes the `UsuarioService` to interact with the business logic layer for user operations.
 *
 * @author LopezS7
 * @version 1.0
 * @since 8/4/2024
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    /**
     * Injected instance of the `UsuarioService` for interacting with user-related business logic.
     */
    private final UsuarioService usuarioService;

    /**
     * Constructor to autowire the `UsuarioService` dependency.
     *
     * @param usuarioService The injected `UsuarioService` instance.
     */
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * This endpoint creates a new `UsuarioModel` entity based on the provided JSON data in the request body.
     * The request body should contain a valid JSON representation of a `UsuarioModel` object.
     *
     * @param usuario The `UsuarioModel` object to be created.
     * @return The newly created `UsuarioModel` object with a generated ID.
     * @throws Exception If any errors occur during user creation.
     */
    @PostMapping
    public UsuarioModel addUsuario(@RequestBody UsuarioModel usuario) throws Exception {
        return usuarioService.addUsuario(usuario);
    }

    /**
     * This endpoint retrieves a specific `UsuarioModel` entity based on the provided ID path variable.
     *
     * @param id The ID of the `UsuarioModel` to be retrieved.
     * @return The `UsuarioModel` object with the matching ID, or null if not found.
     * @throws Exception If any errors occur during user retrieval.
     */
    @GetMapping("/{id}")
    public UsuarioModel getUsuarioById(@PathVariable Long id) throws Exception {
        return usuarioService.getUsuarioById(id);
    }

    /**
     * This endpoint updates an existing `UsuarioModel` entity based on the provided ID path variable
     * and the JSON data in the request body. The ID in the path variable should match the ID of the
     * `UsuarioModel` object in the request body.
     *
     * @param id       The ID of the `UsuarioModel` to be updated.
     * @param usuarioModel The `UsuarioModel` object containing the updated information.
     * @return The updated `UsuarioModel` object.
     * @throws Exception If any errors occur during user update.
     */
    @PutMapping("/{id}")
    public UsuarioModel updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) throws Exception {
        usuarioModel.setId(id);
        return usuarioService.updateUsuario(usuarioModel);
    }

    /**
     * This endpoint deletes an existing `UsuarioModel` entity based on the provided ID path variable.
     *
     * @param id The ID of the `UsuarioModel` to be deleted.
     * @throws Exception If any errors occur during user deletion.
     */
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) throws Exception {
        usuarioService.deleteUsuario(id);
    }
}
