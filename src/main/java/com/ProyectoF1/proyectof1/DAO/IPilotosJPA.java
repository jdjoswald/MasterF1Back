package com.ProyectoF1.proyectof1.DAO;
import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPilotosJPA extends JpaRepository<Piloto,Integer> {

    Piloto findByNombreAndApellidosContainsIgnoreCase(String nombre, String apellidos);

    Piloto findBySiglasEqualsIgnoreCase(String siglas);



}
