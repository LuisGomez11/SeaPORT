import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../../Services/service.service'
import {Servicio} from '../../../Models/Servicios'

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServiciosComponent implements OnInit {

  servicio: Servicio = new Servicio();
  listaServicios: Servicio[];

  constructor(private service: ServiceService) { }

  ngOnInit() {
    this.servicio = new Servicio();
    this.getServicios();
  }


  getServicios() {
    this.service.getServicios()
    .subscribe(data => (this.listaServicios = data));
  }
}
