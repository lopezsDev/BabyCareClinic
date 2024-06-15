package com.project.principal.controllers;

import org.springframework.web.bind.annotation.*;

import com.project.principal.models.CitaMedicaModel;
import com.project.principal.service.CitaMedicaService;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @PostMapping
    public CitaMedicaModel addCitaMedica(@RequestBody CitaMedicaModel citaMedicaModel) {
        return citaMedicaService.saveCitaMedica(citaMedicaModel);
    }

    @GetMapping("/{id}")
    public CitaMedicaModel getCitaMedica(@PathVariable Long id) {
        return citaMedicaService.getCitaMedica(id);
    }

    @PutMapping("/{id}")
    public CitaMedicaModel updateCitaMedica(@PathVariable Long id, @RequestBody CitaMedicaModel citaMedica) {
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

