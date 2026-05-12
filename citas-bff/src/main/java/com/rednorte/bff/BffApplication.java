package com.rednorte.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <--- ¡ESTO ES VITAL! Activa el cliente para llamar a los otros MS
public class BffApplication {
    public static void main(String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }
}
