
package com.api.Backend.controladores;

import com.api.Backend.modelos.Servicio;
import com.api.Backend.servicios.ServicioService;
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
public class ServiciosControlador {

    @Autowired
    ServicioService service;

    @GetMapping("/servicio")
    public List<Servicio> getServicios() {
        return service.getServicios();
    }
    
    @GetMapping("/servicio/{servicioId}")
    public Servicio getCustomer(@PathVariable int servicioId) {
        Servicio s = service.getServicio(servicioId);
        return s;
    }
    
    @PostMapping("/servicio")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio save(@RequestBody Servicio s) {
        s.setId(0);
        service.save(s);
        return s;
    }
    
    @PutMapping("/servicio")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio update(@RequestBody Servicio s){
        service.save(s);
        return s;
    }  
    
    @DeleteMapping("/servicio/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    
}
