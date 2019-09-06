import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../../Services/service.service'
import {Servicio} from '../../../Models/Servicios'

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServiciosComponent implements OnInit {

  constructor(private serviceService: ServiceService) { }

  ngOnInit() {
    this.getGenerado();
  }
  getGenerado() {
    this.serviceService.getServices()
    .subscribe(res =>{
      this.serviceService.servicios = res as Servicio[];
    })
  }
}
