package cl.duoc.rednorte.medicos.repository;

import cl.duoc.rednorte.medicos.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}