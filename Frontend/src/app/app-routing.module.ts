import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// COMPONENTES
import { InicioComponent } from './components/analista/inicio/inicio.component';
import { ServiciosComponent } from './components/analista/servicios/servicios.component';
import { EntidadComponent } from './components/analista/entidad/entidad.component';
import { GeneradosComponent } from './components/analista/generados/generados.component';
import { AsignadosComponent } from './components/analista/asignados/asignados.component';
import { InformesComponent } from './components/analista/informes/informes.component';
import { EstadisticasComponent } from './components/analista/estadisticas/estadisticas.component';
import { RegistrarComponent } from './components/seleccionador/registrar/registrar.component';
import { ConsultarComponent } from './components/seleccionador/consultar/consultar.component';
import { EditComponent } from './components/analista/servicios/edit/edit.component';
import { ErrorComponent } from './components/error/error/error.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'analista', component: InicioComponent},
	{path: 'analista/inicio', component: InicioComponent},
	{path: 'analista/servicios', component: ServiciosComponent},
	{path: 'analista/servicios/edit', component: EditComponent},
	{path: 'analista/entidad', component: EntidadComponent},
	{path: 'analista/generados', component: GeneradosComponent},
	{path: 'analista/asignados', component: AsignadosComponent},
	{path: 'analista/informes', component: InformesComponent},
	{path: 'analista/estadisticas', component: EstadisticasComponent},
	{path: 'seleccionador', component: RegistrarComponent},
	{path: 'seleccionador/registrar', component: RegistrarComponent},
	{path: 'seleccionador/consultar', component: ConsultarComponent},
	{path: '**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
