package cl.duoc.rednorte.citas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data // <--- Verifica que esta línea esté, es la que crea los "get"
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;
}