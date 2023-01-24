package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class VotosDAOImpl implements IVotosDAO {

    @Autowired
    IVotosJPA votosJPA;

    @Override
    public List<Voto> buscarTodos() {
        return votosJPA.findAll();
    }

    @Override
    public Voto buscarVotoPorID(Integer idVoto) {
        Optional<Voto> optional = votosJPA.findById(idVoto);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;}

    @Override
    public List<Voto> buscarVotosPorVotacionyPiloto(Votacion votacion, Integer idPiloto) {
        return votosJPA.findByIdVotacionAndIdPiloto(votacion,idPiloto);
    }

    @Override
    public Voto buscarVotoPorVotacionYCorreo(Votacion votacion, String email) {
        return votosJPA.findByIdVotacionAndEmail(votacion, email);
    }

    @Override
    public void guardarVoto(Voto voto) {
        votosJPA.save(voto);
    }

    @Override
    public void eliminarVoto(Voto voto) {
        votosJPA.delete(voto);
    }

    @Override
    public void actualizarVoto(Voto voto) {
        votosJPA.save(voto);
    }
    @Override
    public void eliminarVotos(List<Voto> votos){
        for(Voto voto : votos){
            eliminarVoto(voto);
        }
    }
}