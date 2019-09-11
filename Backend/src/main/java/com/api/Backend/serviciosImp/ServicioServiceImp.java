
package com.api.Backend.serviciosImp;

import com.api.Backend.servicios.ServicioService;
import com.api.Backend.repositorios.ServicioRepositorio;
import com.api.Backend.modelos.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImp implements ServicioService {

    @Autowired
    ServicioRepositorio repo;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> getServicios() {
        return (List<Servicio>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Servicio s) {
        repo.save(s);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio getServicio(Integer id) {
       return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}