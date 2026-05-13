package com.rednorte.bff;

import com.rednorte.bff.client.CitaClient;
import com.rednorte.bff.dto.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}