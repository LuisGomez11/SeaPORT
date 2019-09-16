import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../../../Models/Servicios';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { ServicioService } from '../../../../Services/Servicios/servicio.service';

import { Router } from '@angular/router';
import {first} from 'rxjs/operators';
import swal from 'sweetalert2';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  servicio: Servicio;
  editForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private router: Router, private service: ServicioService) { }


  ngOnInit() {

    const servicioId = localStorage.getItem('editServicioId');

    if ( !servicioId ) {
      alert('Acción invalida');
      this.router.navigate(['analista/servicios']);
      return;
    }

    this.editForm = this.formBuilder.group({
      id: [],
      nombre: ['', Validators.required]
    });

    this.service.getServicio(+servicioId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  volver(){
    this.router.navigate(['analista/servicios']);
  }

  modificar() {
    this.service.updateServicio(this.editForm.value)
      .pipe(first())
      .subscribe( data => {
        this.router.navigate(['analista/servicios']);
        swal.fire({
          position: 'center',
          type: 'success',
          title: `Servicio modificado con éxito`,
          showConfirmButton: false,
          timer: 1500
        });
      },
      error => {
        alert(error);
      });
  }

}
