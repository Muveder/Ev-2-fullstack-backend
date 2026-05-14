package cl.duoc.rednorte.medicos.service;

import cl.duoc.rednorte.medicos.model.Medico;        // <--- Cambio aquí
import cl.duoc.rednorte.medicos.repository.MedicoRepository; // <--- Cambio aquí

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }
    public Medico obtenerPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }
    public void eliminarMedico(Long id) {
    medicoRepository.deleteById(id);
}
}