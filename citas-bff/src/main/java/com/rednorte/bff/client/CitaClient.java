package com.rednorte.bff.client;

import com.rednorte.bff.dto.CitaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*; // Para usar PostMapping y PutMapping

import java.util.List;

@FeignClient(name = "cita-client", url = "http://citas-ms:8083")
public interface CitaClient {

    @GetMapping("/api/citas")
    List<CitaDTO> getAllCitas();

    @GetMapping("/api/citas/{id}")
    CitaDTO getById(@PathVariable("id") Long id);

    // --- AGREGA ESTOS MÉTODOS ---

    @PostMapping("/api/citas") // Debe coincidir con la ruta en el microservicio de citas
    CitaDTO crearCita(@RequestBody CitaDTO cita);

    @PutMapping("/api/citas/{id}")
    CitaDTO actualizarCita(@PathVariable("id") Long id, @RequestBody CitaDTO cita);

    @DeleteMapping("/api/citas/{id}") // Asegúrate de que la ruta sea completa
    void delete(@PathVariable("id") Long id);
}