package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;

import java.util.List;

public interface IVotosDAO {

    List<Voto> buscarTodos();

    Voto buscarVotoPorID(Integer idVoto);

    List<Voto> buscarVotosPorVotacionyPiloto(Votacion votacion, Integer idPiloto);

    Voto buscarVotoPorVotacionYCorreo(Votacion votacion, String email);

    void guardarVoto(Voto voto);

    void eliminarVoto(Voto voto);

    void actualizarVoto(Voto voto);

    public void eliminarVotos(List<Voto> votos);

}
