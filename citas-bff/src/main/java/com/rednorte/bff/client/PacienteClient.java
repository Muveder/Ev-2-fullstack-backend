package com.rednorte.bff.client;

import com.rednorte.bff.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// El URL debe ser el puerto donde corre el microservicio de pacientes en Docker (8080)
@FeignClient(name = "paciente-client", url = "http://pacientes-ms:8081")
public interface PacienteClient {
    @GetMapping("/api/pacientes")
    List<PacienteDTO> getAllPacientes(); 
}