import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../../../Services/service.service'
import { Servicio } from '../../../Models/Servicios'
import { Router } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServiciosComponent implements OnInit {

  servicio: Servicio = new Servicio();
  listaServicios: Servicio[];
  public formServicio: FormGroup;
  editForm: FormGroup;

  constructor(private service: ServiceService, private formBuilder:FormBuilder, private router: Router) { }

  ngOnInit() {
    this.formServicio = this.formBuilder.group({
      nombre: ['', Validators.required],
    });
    this.servicio = new Servicio();
    this.getServicios();

    const ServicioId = localStorage.getItem('editServicioId');

    this.editForm = this.formBuilder.group({
      id: [],
      nombre: ['', Validators.required]
    });

    this.service.getServicio(+ServicioId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }


  getServicios() {
    this.service.getServicios()
    .subscribe(data => (this.listaServicios = data));
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
    });
    this.getServicios();
    this.ngOnInit();
  }

  editServicio(servicio: Servicio) {
    localStorage.removeItem('editServicioId');
    localStorage.setItem('editServicioId', servicio.id.toString());
    this.router.navigate(['analista/servicios/edit']);
  }

  deleteServicio(servicio: Servicio) {
    swal.fire({
      title: 'Confirmación?',
      text: `¿Seguro que desea eliminar el servicio: ${servicio.nombre}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'Cancelar'
    }).then(result => {
      if (result.value) {
        this.service.deleteServicio(servicio.id).subscribe(data => {
          this.listaServicios = this.listaServicios.filter(s => s !== servicio);
        });

        swal.fire('Eliminado!', 'Se ha eliminado el servicio.', 'success');
      }
    });
  }
}
