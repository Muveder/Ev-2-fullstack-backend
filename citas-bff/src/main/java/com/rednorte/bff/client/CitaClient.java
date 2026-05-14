package com.rednorte.bff.client;

import com.rednorte.bff.dto.CitaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Recuerda: usamos el nombre del servicio en el docker-compose y su puerto interno
@FeignClient(name = "cita-client", url = "http://citas-ms:8083")
public interface CitaClient {

    @GetMapping("/api/citas")
    List<CitaDTO> getAllCitas();

    @GetMapping("/api/citas/{id}")
    CitaDTO getById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
void delete(@PathVariable("id") Long id);
}
