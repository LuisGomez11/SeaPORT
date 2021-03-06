import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Servicio } from '../../Models/Servicios';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  selectedServicio: Servicio;
  servicios: Servicio[];

  readonly url='http://localhost:8090/v1/api/services';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor( private http: HttpClient ) {
    console.log('Servicio Funcionando');
  }

  getServicios(): Observable<Servicio[]> {
    return this.http.get(this.url).pipe(
      map(data => data as Servicio[])
    );
  }

  getServicio(id: String): Observable<Servicio> {
    return this.http.get<Servicio>(`${this.url}/${id}`);
  }

  createServicio(servicio: Servicio): Observable<Servicio> {
    return this.http.post<Servicio>(this.url+'/create', servicio, {headers: this.httpHeaders});
  }

  updateServicio(servicio: Servicio): Observable<Servicio> {
    return this.http.put<Servicio>(this.url+`/update/${servicio.idServices}`, servicio, {headers: this.httpHeaders});
  }

  deleteServicio(id: String): Observable<Servicio> {
    return this.http.delete<Servicio>(this.url+`/delete/${id}`, {headers: this.httpHeaders});
  }

}
