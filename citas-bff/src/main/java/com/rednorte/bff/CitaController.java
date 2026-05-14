package com.rednorte.bff.controller;

import com.rednorte.bff.client.CitaClient;
import com.rednorte.bff.dto.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaClient citaClient;

    @GetMapping
    public List<CitaDTO> listarCitas() {
        return citaClient.getAllCitas();
    }

    @GetMapping("/{id}")
    public CitaDTO buscarPorId(@PathVariable Long id) {
        return citaClient.getById(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaClient.delete(id);  
    }
}