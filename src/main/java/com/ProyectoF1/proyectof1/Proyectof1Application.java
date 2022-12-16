package com.ProyectoF1.proyectof1;

import com.ProyectoF1.proyectof1.model.Carrera;
import com.ProyectoF1.proyectof1.model.Circuito;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.model.Rol;
import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.service.ICarreraService;
import com.ProyectoF1.proyectof1.service.ICircuitoService;
import com.ProyectoF1.proyectof1.service.IEquipoService;
import com.ProyectoF1.proyectof1.service.INoticiaService;
import com.ProyectoF1.proyectof1.service.IPilotoService;
import com.ProyectoF1.proyectof1.service.IRolesService;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Proyectof1Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyectof1Application.class, args);
	}
        
    @Bean
    public CommandLineRunner mappingDemo(ICircuitoService circuitoService,
                                         ICarreraService carreraService,
                                         INoticiaService noticiaService,
                                         IUsuarioService usuarioService,
                                         IRolesService rolesService,
                                         IEquipoService equipoService,
                                         IPilotoService pilotoService
                                         ) {
        return args -> {

           
            
           Circuito cir = new Circuito("Circuito de prueba", "ciudad", "pais", "trazado", 0, 0, 0, 0, 0);
           circuitoService.guardarCircuito(cir);
           
           rolesService.guardarRol(new Rol("Admin"));
           rolesService.guardarRol(new Rol("Team Manager"));
           Usuario user=new Usuario("admin", "admin","admin@admin.com", "admin1234", rolesService.buscarPorId(1), null,true);
           //user.setDefinitivo(true);
           usuarioService.guardarUsuario(user);
          
           Equipo equipo = new Equipo("logo", "twitter", "nombre", "base", "teamChief", "techChief");
           
           equipoService.guardarEquipo(equipo);
           
            Piloto piloto = new Piloto("nombre", "apellidos", "siglas", "dorsal", "foto", "pais", "twitter");
           piloto.setEquipo(equipo);
            pilotoService.guardarPiloto(piloto);
           
           
           
           
                 

       
           
        };
    }
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
