package com.rednorte.bff.client;

import com.rednorte.bff.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "paciente-client", url = "http://pacientes-ms:8081")
public interface PacienteClient {

    @GetMapping("/api/pacientes")
    List<PacienteDTO> getAllPacientes();

    @GetMapping("/api/pacientes/{id}")
    PacienteDTO getById(@PathVariable("id") Long id);

    @PostMapping("/api/pacientes")
    PacienteDTO create(@RequestBody PacienteDTO paciente);

    @PutMapping("/api/pacientes/{id}")
    PacienteDTO update(@PathVariable("id") Long id, @RequestBody PacienteDTO paciente);

    @DeleteMapping("/api/pacientes/{id}")
    void delete(@PathVariable("id") Long id);
}