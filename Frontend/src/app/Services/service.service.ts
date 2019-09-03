import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Generados } from '../Models/generados';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  selectedServiceGenerated: Generados;
  servicesGenerated: Generados[];
  readonly URL_API='localhost:8080/v1/api/servicesGenerated';
  constructor(private http: HttpClient){
    this.selectedServiceGenerated = new Generados();
  }
  getServicesGenerated(){
    return this.http.get(this.URL_API);
  }
}
