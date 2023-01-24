package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VotacionDAOImpl implements IVotacionDAO{

    @Autowired
    IVotacionJPA votacionJPA;

    @Override
    public List<Votacion> buscarTodas() {
        System.out.println("PASA POR VOTACIONES DAO");
        return votacionJPA.findAll();
    }

    @Override
    public Votacion buscarVotacionPorid(Integer id) {
        Optional<Votacion> optional = votacionJPA.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;}

    @Override
    public List<Votacion> buscarVotacionPorTitulo(String titulo) {
        return votacionJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Votacion> buscarVotacionsPorFechaInicio(LocalDate fechaInico) {
        return votacionJPA.findByFechaInicio(fechaInico);
    }

    @Override
    public List<Votacion> buscarVotacionsPorFechaCulminacion(LocalDate fechaCulminacion) {

        return votacionJPA.findByFechaCulminacion(fechaCulminacion);
    }

    @Override
    public void guardarVotacion(Votacion votacion) {
        votacionJPA.save(votacion);

    }

    @Override
    public void eliminarVotacion(Integer id) {
        votacionJPA.deleteById(id);
    }

    @Override
    public void actualizarVotacion(Votacion votacion) {
        votacionJPA.save(votacion);
    }

    @Override
    public void addVoto(Votacion votacion, Voto voto){
        votacion.addVoto(voto);
        votacionJPA.save(votacion);
    }

    @Override
    public List<Voto> deleteVotos(Votacion votacion) {
        List<Voto> votos = votacion.getVotos();
        votacion.setVotos(new ArrayList<Voto>());
        votacionJPA.save(votacion);
        return votos;
    }
}
