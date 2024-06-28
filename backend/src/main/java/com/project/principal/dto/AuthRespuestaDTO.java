package com.project.principal.dto;

import lombok.Data;

/**
 * Esta clase retorna la información del token
 * y el tipo que este sea
 */
@Data
public class AuthRespuestaDTO {
    private String accesToken;
    private String tokenType = "Bearer ";

    public AuthRespuestaDTO(String token) {
        this.accesToken = accesToken;
    }
}
