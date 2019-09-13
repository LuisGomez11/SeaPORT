
package com.api.Backend.servicios;

import com.api.Backend.modelos.Generado;
import java.util.List;

public interface GeneradoService {
    
    public List<Generado> getGenerados();
    public void save(Generado g);
    public Generado getGenerado(Integer id);
    public void delete(Integer id);
    
}
