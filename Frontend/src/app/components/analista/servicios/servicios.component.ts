import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../Services/service.service'
import { Servicio } from '../../../Models/Servicios'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css'],
  providers: [ServiceService]
})
export class ServiciosComponent implements OnInit {

  constructor(private serviceService: ServiceService) { }

  ngOnInit() {
    this.getServicio();
  }
  getServicio() {
    this.serviceService.getServices()
    .subscribe(res =>{
      this.serviceService.servicios = res as Servicio[];
    })
  };
  postServicio(form: NgForm){
    this.serviceService.postService(form.value)
    .subscribe(res =>{
      console.log(res)
    })
    this.getServicio();
    this.resetForm(form);
  };
  putServicio(servicio: Servicio){
    //this.serviceService.putService()
    this.serviceService.selectedServicio = servicio
  }
  resetForm(form?: NgForm){
    if (form) {
      form.reset();
      this.serviceService.selectedServicio = new Servicio();
    }
  };
}
