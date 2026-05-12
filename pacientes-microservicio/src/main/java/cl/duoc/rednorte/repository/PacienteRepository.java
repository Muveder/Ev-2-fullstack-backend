package cl.duoc.rednorte.repository;

import cl.duoc.rednorte.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    // ¡Aquí adentro hay magia pura! 
    // Al extender JpaRepository, Spring Boot nos regala todos los 
    // métodos básicos: save(), findAll(), findById(), deleteById()...

}