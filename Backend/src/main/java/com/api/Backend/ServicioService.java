
package com.api.Backend;

import java.util.List;

public interface ServicioService {

    public List<Servicio> getServicios();
    public void save(Servicio s);
    public Servicio getServicio(Integer id);
    public void delete(Integer id);
    
}
