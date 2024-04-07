package com.project.principal.repository;

import java.util.Optional;
import com.project.principal.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByNombre(String nombreUsuario);
}
