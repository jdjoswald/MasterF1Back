package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CochesDAOImpl implements ICochesDAO {
    @Autowired
    ICochesJPA cochesJPA;

    @Override
    public List<Coche> buscarTodos() {return cochesJPA.findAll();}

    @Override
    public Coche buscarCochePorid(Integer id) {
        Optional<Coche> optional = cochesJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    @Override
    public Coche buscarCochePorCodigo(String siglas) {
        return cochesJPA.findByCodigoContainingIgnoreCase(siglas);
    }

    @Override
    public List<Coche> buscarCochePorNombre(String nombre) {
        return cochesJPA.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public void guardarCoche(Coche coche) { cochesJPA.save(coche);    }

    @Override
    public void eliminarCoche(Integer id) { cochesJPA.deleteById(id); }

    @Override
    public void actualizarCoche(Coche coche) {cochesJPA.save(coche);

    }

    @Override
    public void addEquipo(Integer idCoche, Equipo equipo) {
        Optional<Coche> optionalCoche = cochesJPA.findById(idCoche);
        if (optionalCoche.isPresent()) {
            Coche coche = optionalCoche.get();
            coche.setEquipo(equipo);
            cochesJPA.save(coche);
        }

    }

    @Override
    public void deleteEquipo(Integer idCoche) {
        Optional<Coche> optionalCoche = cochesJPA.findById(idCoche);
        if (optionalCoche.isPresent()) {
            Coche coche = optionalCoche.get();
            coche.setEquipo(new Equipo());
            cochesJPA.save(coche);
        }

    }

   
}
