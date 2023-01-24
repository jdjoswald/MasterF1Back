package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.ICochesDAO;
import com.ProyectoF1.proyectof1.DAO.IEquiposDAO;
import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CochesServiceImpl implements ICocheService{
    
    @Autowired
    ICochesDAO cochesDAO;
    
    @Autowired
    IEquiposDAO equiposDAO;
    
    @Override
    public List<Coche> buscarTodos() {
        return cochesDAO.buscarTodos();
    }

    @Override
    public Coche buscarCochePorid(Integer id) {
        return cochesDAO.buscarCochePorid(id);
    }

    @Override
    public Coche buscarCochePorCodigo(String siglas) {
        return cochesDAO.buscarCochePorCodigo(siglas);
    }

    @Override
    public List<Coche> buscarCochePorNombre(String nombre) {
        return cochesDAO.buscarCochePorNombre(nombre);
    }

    @Override
    public boolean guardarCoche(Coche coche) {
        try {
            int id = coche.getId();
            String codigo = coche.getCodigo();
            if ((buscarCochePorid(id)==null) && (buscarCochePorCodigo(codigo) ==null)){
                cochesDAO.guardarCoche(coche);
                return true;
            }
        }catch (NullPointerException e){
            String codigo = coche.getCodigo();
            if ((buscarCochePorCodigo(codigo) ==null)){
                cochesDAO.guardarCoche(coche);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCoche(Integer id) {
        Coche coche = cochesDAO.buscarCochePorid(id);
        if (coche != null){
            Equipo equipo = coche.getEquipo();
            equiposDAO.deleteCoche(equipo.getId(),id);
            cochesDAO.eliminarCoche(coche.getId());
            return true;
        }
        return false;

    }

    @Override
    public boolean actualizarCoche(Coche coche) {
        try {
            int id = coche.getId();
            String codigo = coche.getCodigo();
            if ((buscarCochePorid(id)!=null) && (buscarCochePorCodigo(codigo) !=null)){
                cochesDAO.guardarCoche(coche);
                return true;
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;
    }

    @Override
    public boolean addEquipo(Integer idCoche, Integer idEquipo) {
        Coche coche = cochesDAO.buscarCochePorid(idCoche);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((coche!=null)&&(equipo!=null))
        {
            equiposDAO.addCoche(idEquipo, coche);
            cochesDAO.addEquipo(idCoche,equipo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEquipo(Integer idCoche) {
        Coche coche = cochesDAO.buscarCochePorid(idCoche);
        Equipo equipo = null;
        if ((coche!=null)) {
            equipo = equiposDAO.buscarEquipoPorid(coche.getEquipo().getId());
            if ((equipo!=null)) {
                equiposDAO.deleteCoche(equipo.getId(), coche.getId());
                cochesDAO.deleteEquipo(equipo.getId());
                return true;
            }
        }
        return false;

    }
}
