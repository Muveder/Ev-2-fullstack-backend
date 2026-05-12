package cl.duoc.rednorte.citas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients; // <--- Agregar este import

@SpringBootApplication
@EnableFeignClients // <--- AGREGAR ESTA LÍNEA
public class CitasMicroservicioApplication {
    public static void main(String[] args) {
        SpringApplication.run(CitasMicroservicioApplication.class, args);
    }
}