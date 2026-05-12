package cl.duoc.rednorte.medicos.controller;

import cl.duoc.rednorte.medicos.model.Medico;     
import cl.duoc.rednorte.medicos.service.MedicoService; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoService.obtenerTodos(); // Asegúrate de que este método exista en tu Service
    }

    // ESTE ES EL MÉTODO QUE TE FALTA O ESTÁ MAL
    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return medicoService.obtenerPorId(id);
    }

    @PostMapping
    public Medico crear(@RequestBody Medico medico) {
        return medicoService.guardar(medico);
    }
}