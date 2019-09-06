import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Servicio } from '../Models/Servicios';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  selectedServicio: Servicio;
  servicios: Servicio[];

  readonly URL_API='localhost:8080/api/services';
  
  constructor(private http: HttpClient){
    this.selectedServicio = new Servicio();
  }
  getServices(){
    return this.http.get(this.URL_API);
  }
}
