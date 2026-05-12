package cl.duoc.rednorte.medicos.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicos")
@Data 
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String rut;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String email;
}