package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVotosJPA extends JpaRepository<Voto,Integer> {

    List<Voto> findByIdVotacionAndIdPiloto(Votacion votacion, Integer idPiloto);

    Voto findByIdVotacionAndEmail(Votacion votacion, String email);

}
