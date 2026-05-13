package com.rednorte.bff.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CitaDTO {
    private Long id;
    private Long pacienteId;  // O como se llame en tu micro de Citas (ej: idPaciente)
    private Long medicoId;    // O como se llame en tu micro de Citas (ej: idMedico)
    private LocalDateTime fecha;
    private String motivo;
    private String estado;    // Ej: PENDIENTE, COMPLETADA
}
