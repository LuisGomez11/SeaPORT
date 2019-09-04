import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// COMPONENTES
import { InicioComponent } from './components/analista/inicio/inicio.component';
import { ServiciosComponent } from './components/analista/servicios/servicios.component';
import { EntidadComponent } from './components/analista/entidad/entidad.component';
import { GenerarComponent } from './components/analista/generar/generar.component';
import { GeneradosComponent } from './components/analista/generados/generados.component';
import { AsignadosComponent } from './components/analista/asignados/asignados.component';
import { InformesComponent } from './components/analista/informes/informes.component';
import { EstadisticasComponent } from './components/analista/estadisticas/estadisticas.component';
import { RegistrarComponent } from './components/seleccionador/registrar/registrar.component';
import { ConsultarComponent } from './components/seleccionador/consultar/consultar.component';

const routes: Routes = [
	{path: 'analista', component: InicioComponent},
	{path: 'analista/inicio', component: InicioComponent},
	{path: 'analista/servicios', component: ServiciosComponent},
	{path: 'analista/entidad', component: EntidadComponent},
	{path: 'analista/generar', component: GenerarComponent},
	{path: 'analista/generados', component: GeneradosComponent},
	{path: 'analista/asignados', component: AsignadosComponent},
	{path: 'analista/informes', component: InformesComponent},
	{path: 'analista/estadisticas', component: EstadisticasComponent},
	{path: 'seleccionador', component: RegistrarComponent},
	{path: 'seleccionador/registrar', component: RegistrarComponent},
	{path: 'seleccionador/consultar', component: ConsultarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }