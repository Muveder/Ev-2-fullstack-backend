package cl.duoc.rednorte.citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "medico-client", url = "http://localhost:8081")
public interface MedicoClient {
    @GetMapping("/api/medicos/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}