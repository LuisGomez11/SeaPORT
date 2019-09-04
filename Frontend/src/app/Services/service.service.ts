import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Generados } from '../Models/generados';
import { Servicio } from '../Models/Servicios';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  selectedServicio: Servicio;
  servicios: Servicio[];

  selectedGenerado: Generados;
  generados: Generados[];

  readonly URL_API='localhost:8080/v1/api/servicios';
  
  constructor(private http: HttpClient){
    this.selectedServicio = new Servicio();
  }
  getServicios(){
    return this.http.get(this.URL_API);
  }
}
