
package com.api.Backend.controladores;

import com.api.Backend.modelos.Generado;
import com.api.Backend.servicios.GeneradoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class GeneradoControlador {
    
    @Autowired
    GeneradoService service;

    @GetMapping("/generado")
    public List<Generado> getGenerados() {
        return service.getGenerados();
    }
    
    @GetMapping("/generado/{generadoId}")
    public Generado getGenerado(@PathVariable int generadoId) {
        Generado g = service.getGenerado(generadoId);
        return g;
    }
    
    @PostMapping("/generado")
    @ResponseStatus(HttpStatus.CREATED)
    public Generado save(@RequestBody Generado g) {
        g.setId(0);
        service.save(g);
        return g;
    }
    
    @PutMapping("/generado")
    @ResponseStatus(HttpStatus.CREATED)
    public Generado update(@RequestBody Generado g){
        service.save(g);
        return g;
    }  
    
    @DeleteMapping("/generado/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    
}
