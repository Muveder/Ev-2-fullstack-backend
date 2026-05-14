package com.rednorte.bff.client;

import com.rednorte.bff.dto.MedicoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "medico-client", url = "http://medicos-ms:8082") 
public interface MedicoClient {

    @PostMapping("/api/medicos")
MedicoDTO create(@RequestBody MedicoDTO medico);

    @GetMapping("/api/medicos")
    List<MedicoDTO> getAllMedicos();

    @GetMapping("/api/medicos/{id}")
    MedicoDTO getById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
void delete(@PathVariable("id") Long id);
}