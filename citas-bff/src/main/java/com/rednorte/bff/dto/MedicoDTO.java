package com.rednorte.bff.dto;

import lombok.Data;

@Data // Si usas Lombok, esto genera Getters y Setters automáticamente
public class MedicoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String rut;
    private String email;
}