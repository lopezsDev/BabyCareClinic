package com.project.principal.service;

import java.util.Optional;
import com.project.principal.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.principal.models.UsuarioModel;

/**
 * Service class responsible for managing CRUD operations for users.
 *
 * @author LopezS7
 */
@Service
public class UsuarioService {

    /**
     * Repository for interacting with the user database.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor that injects the user repository dependency.
     *
     * @param usuarioRepository The user repository to use.
     */
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Adds a new user to the database.
     *
     * @param usuarioModel The user model to add.
     * @return The added user with its ID assigned by the database.
     */
    public UsuarioModel addUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    /**
     * Updates an existing user in the database.
     *
     * @param usuariomodel The user model with the updated data.
     * @return The updated user in the database, or null if the user does not exist.
     * @throws Exception If an error occurs during the update.
     */
    @SneakyThrows
    public UsuarioModel updateUsuario(UsuarioModel usuariomodel) {
        boolean exists = usuarioRepository.existsById(usuariomodel.getId());

        if (!exists) {
            throw new Exception("User with ID " + usuariomodel.getId() + " does not exist.");
        } else if (exists) {
            // Create a new object with the updated data
            UsuarioModel usuarioActualizadoBD = new UsuarioModel();
            usuarioActualizadoBD.setId(usuariomodel.getId());
            usuarioActualizadoBD.setNombre(usuariomodel.getNombre());
            usuarioActualizadoBD.setApellido(usuariomodel.getApellido());
            usuarioActualizadoBD.setEmail(usuariomodel.getEmail());
            usuarioActualizadoBD.setPassword(usuariomodel.getPassword());
            usuarioActualizadoBD.setRol(usuariomodel.getRol());

            // Save the new object in the database
            usuarioRepository.save(usuarioActualizadoBD);

            return usuarioActualizadoBD;
        }
        return null;
    }

    /**
     * Gets a user by its ID.
     *
     * @param id The ID of the user to get.
     * @return The found user, or null if it does not exist.
     * @throws RuntimeException If the user is not found.
     */
    public UsuarioModel getUsuarioById(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("User with ID " + id + " not found.");
        }
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

