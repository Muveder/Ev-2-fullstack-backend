package com.rednorte.bff;

import com.rednorte.bff.client.MedicoClient;
import com.rednorte.bff.dto.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoClient medicoClient;

    @GetMapping
    public List<MedicoDTO> listarMedicos() {
        return medicoClient.getAllMedicos();
    }
}