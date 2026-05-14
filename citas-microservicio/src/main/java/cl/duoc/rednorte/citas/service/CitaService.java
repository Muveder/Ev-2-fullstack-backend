package cl.duoc.rednorte.citas.service;

import cl.duoc.rednorte.citas.model.Cita;
import cl.duoc.rednorte.citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }
    

    public Cita agendarCita(Cita cita) {
        return citaRepository.save(cita);
        
    }
    public void eliminarCita(long id) {
        citaRepository.deleteById(id);
    }
}
