import { Component, OnInit } from '@angular/core';

import { ServiceService } from '../../../Services/service.service'
import { Servicio } from '../../../Models/Servicios'
import { NgForm } from '@angular/forms';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../../../Services/service.service'
import { Servicio } from '../../../Models/Servicios'
import { Router } from '@angular/router';
import swal from 'sweetalert2';


@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css'],
  providers: [ServiceService]
})
export class ServiciosComponent implements OnInit {

  servicio: Servicio = new Servicio();
  listaServicios: Servicio[];
  public formServicio: FormGroup;
  editForm: FormGroup;

  constructor(private service: ServiceService, private formBuilder: FormBuilder, private router: Router) { }

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

    this.formServicio = this.formBuilder.group({
      nombre: ['', Validators.required],
    });
    this.servicio = new Servicio();
    this.getServicios();
  }

  addServicio() {
    this.service.createServicio(this.formServicio.value).subscribe(data => {
      swal.fire({
        position: 'center',
        type: 'success',
        title: "Correcto!",
        text: "Servicio registrado correctamente",
        showConfirmButton: false,
        timer: 1500
      });
      this.getServicios();
      this.formServicio.reset();
    },error => {
      swal.fire({
        position: 'center',
        type: 'error',
        title: "Error!",
        text: "Error al registrar el servicio",
        showConfirmButton: false,
        timer: 2000
      });
    });
  }

  editServicio(servicio: Servicio) {
    localStorage.removeItem('editServicioId');
    localStorage.setItem('editServicioId', servicio.id.toString());
    this.router.navigate(['analista/servicios/edit']);
  }

  async deleteServicio(servicio: Servicio) {

    let result = await swal.fire({
      title: 'Confirmación',
      text: `¿Seguro que desea eliminar el servicio: ${servicio.nombre}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'Cancelar'
    })

    if (result.value) {
      this.service.deleteServicio(servicio.id).subscribe(data => {
        this.listaServicios = this.listaServicios.filter(s => s !== servicio);
      });
      swal.fire('Eliminado!', 'Se ha eliminado el servicio.', 'success');
    }


  }
  resetForm(form?: NgForm){
    if (form) {
      form.reset();
      this.serviceService.selectedServicio = new Servicio();
    }
  };
}
