package com.rednorte.bff;

import com.rednorte.bff.client.MedicoClient;
import com.rednorte.bff.dto.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")

public class MedicoController {

    @Autowired
    private MedicoClient medicoClient;

    @PostMapping // <--- Este es el que falta
    public MedicoDTO crear(@RequestBody MedicoDTO medico) {
        return medicoClient.create(medico); // O como se llame el método en tu Feign Client
    }

    @GetMapping
    public List<MedicoDTO> listarMedicos() {
        return medicoClient.getAllMedicos();
    }

    @GetMapping("/{id}")
    public MedicoDTO buscarPorId(@PathVariable Long id) {
        return medicoClient.getById(id);
    }


    @DeleteMapping("/{id}")
public void eliminar(@PathVariable Long id) {
    // Llamada al cliente feign
    medicoClient.delete(id); 
}
}