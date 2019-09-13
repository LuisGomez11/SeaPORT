import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Servicio } from '../Models/Servicios';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  selectedServicio: Servicio;
  servicios: Servicio[];


  readonly URL_API='http://localhost:8080/v1/api';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  
  constructor( private http: HttpClient ) {
    this.selectedServicio = new Servicio();
  }
  getServices(){
    return this.http.get(this.URL_API + '/services');
  };

  postService(Servicio: Servicio){
    return this.http.post(this.URL_API + '/services/create',Servicio);
  };

  putService(servicio: Servicio){
    return this.http.put(this.URL_API + `/services/update/${servicio.idServices}`, servicio)

  };
}
