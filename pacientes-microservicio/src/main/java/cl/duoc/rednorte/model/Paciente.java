package cl.duoc.rednorte.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rut;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String email;
    private String telefono;

}