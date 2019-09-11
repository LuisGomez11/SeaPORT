import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GeneradoService } from '../../../Services/Generados/generado.service'
import { Generados } from '../../../Models/generados'
import { Router } from '@angular/router';
import swal from 'sweetalert2';


@Component({
  selector: 'app-generados',
  templateUrl: './generados.component.html',
  styleUrls: ['./generados.component.css']
})
export class GeneradosComponent implements OnInit {

  generado: Generados = new Generados();
  listaGenerados: Generados[];
  public formGenerado: FormGroup;
  editForm: FormGroup;

  constructor(private service: GeneradoService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.formGenerado = this.formBuilder.group({
      terminal: ['', Validators.required],
      id_entidadM: ['N/A', Validators.required],
      lloyd: ['', Validators.required],
      uvi: ['', Validators.required],
      referencia: ['', Validators.required],
      muelle: ['N/A',Validators.required],
      id_entidadG: ['N/A', Validators.required],
      fechaCita: ['', Validators.required],
      horaCita: ['', Validators.required],
      hrsOp: ['', Validators.required],
      fechaFinal: ['', Validators.required],
      horaFinal: ['', Validators.required],
      id_servicio: ['', Validators.required],
      estado: ['No asignado', Validators.required],
    });
    this.generado = new Generados();
    this.getGenerados();
  }

  getGenerados() {
    this.service.getGenerados()
      .subscribe(data =>
        this.listaGenerados = data
      );
  }

  addGenerado() {
    this.service.createServicio(this.formGenerado.value).subscribe(data => {
      swal.fire({
        position: 'center',
        type: 'success',
        title: "Correcto!",
        text: "Servicio generado correctamente",
        showConfirmButton: false,
        timer: 1500
      });
      this.getGenerados();
      this.formGenerado.reset();
    },error => {
      swal.fire({
        position: 'center',
        type: 'error',
        title: "Error!",
        text: "Error al generar el servicio",
        showConfirmButton: false,
        timer: 2000
      });
    });
  }
  
}
