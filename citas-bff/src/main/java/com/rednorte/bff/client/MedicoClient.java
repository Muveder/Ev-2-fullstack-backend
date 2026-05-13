package com.rednorte.bff.client;

import com.rednorte.bff.dto.MedicoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "medico-client", url = "http://medicos-ms:8082") 
public interface MedicoClient {

    @GetMapping("/api/medicos")
    List<MedicoDTO> getAllMedicos();
}