package com.project.principal.controllers;

import com.project.principal.dto.AuthRespuestaDTO;
import com.project.principal.dto.LoginDTO;
import com.project.principal.dto.RegistroDTO;
import com.project.principal.models.RolModel;
import com.project.principal.models.UsuarioModel;
import com.project.principal.repository.RolesRepository;
import com.project.principal.repository.UsuarioRepository;
import com.project.principal.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    private RolesRepository rolesRepository;

    private UsuarioRepository usuarioRepository;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, RolesRepository rolesRepository, UsuarioRepository usuarioRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.usuarioRepository = usuarioRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     *Metodo para registrar un usuario con un role tipo medico
     */

    @PostMapping("registerMedico")
    public ResponseEntity<String>  registrar(@RequestBody RegistroDTO registroDTO){
        if (usuarioRepository.existsByNombre(registroDTO.getUsername())){
            return new ResponseEntity<>("El usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre(registroDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        RolModel roles = rolesRepository.findByName("MEDICO").get();
        usuario.setRol(Collections.singletonList(roles));
        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Medico registrado con exito", HttpStatus.OK);
    }

    /**
     * Metodo para loguear un usuario tipo Administrativo
     */
    @PostMapping("registerAdmin")
    public ResponseEntity<String>  registrarAdmin(@RequestBody RegistroDTO registroDTO){
        if (usuarioRepository.existsByNombre(registroDTO.getUsername())){
            return new ResponseEntity<>("El usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre(registroDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        RolModel roles = rolesRepository.findByName("ADMINISTRADOR").get();
        usuario.setRol(Collections.singletonList(roles));
        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Administrativo registrado con exito", HttpStatus.OK);
    }

    /**
     * Metodo para loguear usuarios tipo personal medico
     */

    @PostMapping("registerPersonalMed")
    public ResponseEntity<String>  registrarPersonalMedico(@RequestBody RegistroDTO registroDTO){
        if (usuarioRepository.existsByNombre(registroDTO.getUsername())){
            return new ResponseEntity<>("El usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre(registroDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        RolModel roles = rolesRepository.findByName("PERSONAL MEDICO").get();
        usuario.setRol(Collections.singletonList(roles));
        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Agente médico registrado con exito", HttpStatus.OK);
    }

    /**
     * Metodo para loguear un usuario y obtener un token
     */
    @PostMapping("login")
    public ResponseEntity<AuthRespuestaDTO> login(@RequestBody LoginDTO loginDTO){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return new ResponseEntity<>(new AuthRespuestaDTO(token), HttpStatus.OK);
    }

}
