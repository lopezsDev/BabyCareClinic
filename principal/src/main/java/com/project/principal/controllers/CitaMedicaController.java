package com.project.principal.controllers;

import org.springframework.web.bind.annotation.*;

import com.project.principal.models.CitaMedica;
import com.project.principal.service.CitaMedicaService;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @PostMapping
    public CitaMedica addCitaMedica(@RequestBody CitaMedica citaMedica) {
        return citaMedicaService.saveCitaMedica(citaMedica);
    }

    @GetMapping("/{id}")
    public CitaMedica getCitaMedica(@PathVariable Long id) {
        return citaMedicaService.getCitaMedica(id);
    }

    @PutMapping("/{id}")
    public CitaMedica updateCitaMedica(@PathVariable Long id, @RequestBody CitaMedica citaMedica) {
        citaMedica.setId(id);
        return citaMedicaService.saveCitaMedica(citaMedica);
    }

    @DeleteMapping("/{id}")
        public String deleteCitaMedica(@PathVariable("id") Long id) {
        boolean ok = this.citaMedicaService.deleteCitaMedica(id);
        if (ok){
            return "La cita medica con el id:" + id +" fué eliminada.";
        }else{
            return "La cita medica con el id:" + id +" no se pudo eliminar.";
        }
    }
}

