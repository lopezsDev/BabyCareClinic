package com.project.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.principal.service.HistorialMedicoService;

@RestController
@RequestMapping("/api")
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    @Autowired
    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }
    
    @GetMapping("/informes/{pacienteId}")
    public String getInformeMedico(@PathVariable Long pacienteId) {

        return "Informe médico para el paciente con ID: " + pacienteId;
    }

    @GetMapping("/estadisticas/medicas")
    public String getEstadisticasMedicas() {

        return "Estadísticas médicas avanzadas";
    }
}

