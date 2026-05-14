package com.rednorte.bff;

import com.rednorte.bff.client.CitaClient;
import com.rednorte.bff.dto.CitaDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CitaController.class)
public class CitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitaClient citaClient;

    @Test
    public void testListarCitasDeberiaRetornarListaVaciaAlInicio() throws Exception {
        // Simulamos que el microservicio de citas responde con una lista vacía
        Mockito.when(citaClient.getAllCitas()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/citas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    public void testBuscarCitaPorIdDeberiaRetornarCitaEspecifica() throws Exception {
        // 1. Datos simulados
        CitaDTO cita = new CitaDTO();
        cita.setId(10L);
        cita.setFecha(LocalDateTime.parse("2026-05-20T10:00:00"));
        cita.setMotivo("Control Anual");

        // 2. Simulación
        Mockito.when(citaClient.getById(10L)).thenReturn(cita);

        // 3. Verificación
        mockMvc.perform(get("/api/citas/10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.motivo").value("Control Anual"))
                .andExpect(jsonPath("$.id").value(10));
    }
}