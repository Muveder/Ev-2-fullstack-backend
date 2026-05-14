package com.rednorte.bff.controller;

import com.rednorte.bff.client.PacienteClient;
import com.rednorte.bff.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteClient pacienteClient;

    @GetMapping
    public List<PacienteDTO> listar() {
        return pacienteClient.getAllPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscar(@PathVariable Long id) {
        return pacienteClient.getById(id);
    }

    @PostMapping
    public PacienteDTO crear(@RequestBody PacienteDTO paciente) {
        return pacienteClient.create(paciente);
    }

    @PutMapping("/{id}")
    public PacienteDTO actualizar(@PathVariable Long id, @RequestBody PacienteDTO paciente) {
        return pacienteClient.update(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pacienteClient.delete(id);
    }
}