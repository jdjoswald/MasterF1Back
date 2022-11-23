package com.ProyectoF1.proyectof1;

import com.ProyectoF1.proyectof1.model.Circuito;
import com.ProyectoF1.proyectof1.service.ICircuitoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Proyectof1Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyectof1Application.class, args);
	}
        
    @Bean
    public CommandLineRunner mappingDemo(ICircuitoService circuitoService
                                         ) {
        return args -> {

           
            
            
           circuitoService.guardarCircuito(new Circuito("Circuito de prueba", "ciudad", "pais", "trazado", 0, 0, 0, 0, 0));
           
         

       
           
        };
    }

}
