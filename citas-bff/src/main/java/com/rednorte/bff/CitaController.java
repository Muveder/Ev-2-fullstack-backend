package com.rednorte.bff;

import com.rednorte.bff.client.CitaClient;
import com.rednorte.bff.dto.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todas las anotaciones de una vez
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

    @GetMapping("/{id}")
    public CitaDTO buscarPorId(@PathVariable Long id) {
        return citaClient.getById(id);
    }

    // --- MÉTODOS QUE FALTABAN ---

    @PostMapping // Para CREAR
    public CitaDTO crear(@RequestBody CitaDTO cita) {
        return citaClient.crearCita(cita);
    }

    @PutMapping("/{id}") // Para EDITAR
    public CitaDTO actualizar(@PathVariable Long id, @RequestBody CitaDTO cita) {
        return citaClient.actualizarCita(id, cita);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaClient.delete(id);  
    }
}