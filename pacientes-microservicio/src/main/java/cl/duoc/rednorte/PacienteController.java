package cl.duoc.rednorte;

import cl.duoc.rednorte.model.Paciente;
import cl.duoc.rednorte.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // 1. LISTAR TODOS
    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.obtenerTodos();
    }

    // 2. BUSCAR POR ID (Ej: http://localhost:8080/api/pacientes/1)
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR
    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    // 4. ACTUALIZAR (Ej: http://localhost:8080/api/pacientes/1)
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente detalles) {
        return pacienteService.obtenerPorId(id).map(paciente -> {
            paciente.setNombre(detalles.getNombre());
            paciente.setApellido(detalles.getApellido());
            paciente.setEmail(detalles.getEmail());
            paciente.setTelefono(detalles.getTelefono());
            // No actualizamos el RUT ni el ID por seguridad
            return ResponseEntity.ok(pacienteService.guardar(paciente));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR (Ej: http://localhost:8080/api/pacientes/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}