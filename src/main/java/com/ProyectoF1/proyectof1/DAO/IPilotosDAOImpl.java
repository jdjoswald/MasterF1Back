package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IPilotosDAOImpl implements IPilotosDAO {
    @Autowired
    IPilotosJPA pilotosJPA;
    
    @Override
    public List<Piloto> buscarTodos() {
        return pilotosJPA.findAll();
    }

    @Override
    public Piloto buscarPilotoPorid(Integer id) {
        Optional<Piloto> optional = pilotosJPA.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Piloto buscarPilotoPorSiglas(String siglas) {
        return pilotosJPA.findBySiglasEqualsIgnoreCase(siglas);
    }

    @Override
    public Piloto buscarPilotoPorNombreApellidos(String nombre, String apellidos) {
        return pilotosJPA.findByNombreAndApellidosContainsIgnoreCase(nombre, apellidos);
    }

    @Override
    public List<Piloto> buscarPilotoPorNombre(String nombre) {
        return  pilotosJPA.findByNombreIsLikeIgnoreCase(nombre);
    }

    @Override
    public List<Piloto> buscarPilotoPorApellidos(String apellidos) {
        return  pilotosJPA.findByApellidosIsLikeIgnoreCase(apellidos);
    }

    @Override
    public List<Piloto> buscarPilotoPorPais(String pais) {
        return pilotosJPA.findByPaisIsLikeIgnoreCase(pais);
    }

    @Override
    public void guardarPiloto(Piloto piloto) { pilotosJPA.save(piloto);

    }

    @Override
    public void eliminarPiloto(Integer id) {pilotosJPA.deleteById(id);

    }

    @Override
    public void actualizarPiloto(Piloto piloto) {pilotosJPA.save(piloto);

    }

    @Override
    public void deleteEquipo(Integer idPiloto) {
        Optional<Piloto> optionalPiloto = pilotosJPA.findById(idPiloto);
        if (optionalPiloto.isPresent()) {
            Piloto piloto = optionalPiloto.get();
            piloto.setEquipo(null);
            pilotosJPA.save(piloto);
        }

    }

    @Override
    public void addEquipo(Integer idPiloto, Equipo equipo) {
        Optional<Piloto> optionalPiloto = pilotosJPA.findById(idPiloto);
        if (optionalPiloto.isPresent()) {
            Piloto piloto = optionalPiloto.get();
            piloto.setEquipo(equipo);
            pilotosJPA.save(piloto);
        }
    }



}
