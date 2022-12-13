package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IEquiposDAOImpl implements IEquiposDAO {

    @Autowired
    IEquiposJPA equiposJPA;

    @Override
    public List<Equipo> buscarTodos() {return equiposJPA.findAll();
    }

    @Override
    public Equipo buscarEquipoPorid(Integer id) {
        Optional<Equipo> optional = equiposJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Equipo> buscarEquipoPorBase(String base) {return equiposJPA.findByBaseContainingIgnoreCase(base);
    }

    @Override
    public List<Equipo> buscarEquipoPorNombre(String nombre) {
        return equiposJPA.findByNombreContainingIgnoreCase(nombre);
    }


    @Override
    public void guardarEquipo(Equipo equipo) {equiposJPA.save(equipo);

    }

    @Override
    public void eliminarEquipo(Integer id) {equiposJPA.deleteById(id);

    }

    @Override
    public void actualizarEquipo(Equipo equipo) {equiposJPA.save(equipo);

    }

    @Override
    public void addPiloto(Integer idEquipo, Piloto piloto){
        Optional<Equipo> optionalEquipo = equiposJPA.findById(idEquipo);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.setPiloto(piloto);
            equiposJPA.save(equipo);
        }
            }

    @Override
    public void deletePiloto(Integer idEquipo, Integer idPiloto) {
        Optional<Equipo> optionalEquipo = equiposJPA.findById(idEquipo);
        if (optionalEquipo.isPresent()) {
           Equipo equipo = optionalEquipo.get();
           equipo.deletePiloto(idPiloto);
           equiposJPA.save(equipo);
        }

    }

    @Override
    public void addCoche( Integer idEquipo, Coche coche) {
        Optional<Equipo> optionalEquipo = equiposJPA.findById(idEquipo);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.setCoche(coche);
            equiposJPA.save(equipo);
        }
    }

    @Override
    public void deleteCoche(Integer idEquipo, Integer idCoche) {
        Optional<Equipo> optionalEquipo = equiposJPA.findById(idEquipo);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.deletePiloto(idCoche);
            equiposJPA.save(equipo);
        }

    }
}
