package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.model.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVotacionJPA  extends JpaRepository<Votacion,Integer> {

    //List<Votacion> findByIdUsuario(Integer usuario);

    List<Votacion> findByTituloContainingIgnoreCase(String titulo);

    List<Votacion> findByFechaInicio(LocalDate fechaInicio);

    List<Votacion> findByFechaCulminacion (LocalDate fechaInicio);
}
