import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceService } from '../../../Services/service.service'
import { Generados } from 'src/app/Models/generados';
@Component({
  selector: 'app-generados',
  templateUrl: './generados.component.html',
  styleUrls: ['./generados.component.css'],
  providers:[ServiceService]
})
export class GeneradosComponent implements OnInit {

  constructor(private serviceService: ServiceService){ }

  ngOnInit() {
    this.getServiceGenerated()
  }
  getServiceGenerated() {
    this.serviceService.getServicesGenerated()
    .subscribe(res => {
      this.serviceService.servicesGenerated = res as Generados[];
      console.log(res); 
    });
  }
}
