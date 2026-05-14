package cl.duoc.rednorte.citas.controller;

import cl.duoc.rednorte.citas.model.Cita;
import cl.duoc.rednorte.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> listarTodas() {
        return citaService.listarTodas();
    }

   @GetMapping("/{id}")
public Cita buscarPorId(@PathVariable Long id) {
    return citaService.obtenerPorId(id);
}

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.agendarCita(cita);
    }
@   DeleteMapping("/{id}")
public void eliminar(@PathVariable Long id) {
    citaService.eliminarCita(id);
}    
}