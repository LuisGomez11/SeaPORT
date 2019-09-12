
package com.api.Backend.serviciosImp;

import com.api.Backend.modelos.Generado;
import com.api.Backend.repositorios.GeneradoRepositorio;
import com.api.Backend.servicios.GeneradoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneradoServiceImp implements GeneradoService{

    @Autowired
    GeneradoRepositorio repo;

    
    @Override
    @Transactional(readOnly = true)
    public List<Generado> getGenerados() {
        return (List<Generado>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Generado g) {
        repo.save(g);
    }

    @Override
    @Transactional(readOnly = true)
    public Generado getGenerado(Integer id) {
       return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
       repo.deleteById(id);
    }
    
}
