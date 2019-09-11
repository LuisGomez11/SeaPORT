import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Generados } from '../../Models/generados'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GeneradoService {

  selectedGenerado: Generados;
  generados: Generados[];

  readonly url='http://localhost:8080/api/generado';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor( private http: HttpClient ) {
    console.log('Servicio Funcionando');
  }

  getGenerados(): Observable<Generados[]> {
    return this.http.get(this.url).pipe(
      map(data => data as Generados[])
    );
  }

  createServicio(generado: Generados): Observable<Generados> {
    return this.http.post<Generados>(this.url, generado, {headers: this.httpHeaders});
  }

}
