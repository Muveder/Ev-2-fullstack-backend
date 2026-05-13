package com.rednorte.bff;

import com.rednorte.bff.client.PacienteClient;
import com.rednorte.bff.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes") // Esta es la URL que pondrás en el navegador
public class PacienteController {

    @Autowired
    private PacienteClient pacienteClient;

    @GetMapping
    public List<PacienteDTO> listarTodos() {
        // El BFF llama al microservicio de pacientes a través del Client
        return pacienteClient.getAllPacientes();
    }
}