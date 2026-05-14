package com.rednorte.bff;

import com.rednorte.bff.client.MedicoClient;
import com.rednorte.bff.dto.MedicoDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MedicoController.class)
public class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicoClient medicoClient; // Simulamos el cliente Feign

    @Test
    public void testListarMedicosDeberiaRetornarLista() throws Exception {
        // 1. Preparar los datos simulados
        MedicoDTO medico = new MedicoDTO();
        medico.setId(1L);
        medico.setNombre("Dr. Simi");
        medico.setEspecialidad("General");

        // 2. Definir comportamiento del Mock (Simular respuesta del microservicio)
        Mockito.when(medicoClient.getAllMedicos()).thenReturn(Arrays.asList(medico));

        // 3. Ejecutar la petición al controlador y verificar resultados
        mockMvc.perform(get("/api/medicos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Dr. Simi"))
                .andExpect(jsonPath("$[0].especialidad").value("General"));
    }
}