import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule}from '@angular/forms';

// IMPORTACION DEL MODULO DE RUTAS
import { AppRoutingModule } from './app-routing.module';

// IMPORTACION DE COMPONENTES
import { AppComponent } from './app.component';
import { InicioComponent } from './components/analista/inicio/inicio.component';
import { ServiciosComponent } from './components/analista/servicios/servicios.component';
import { EntidadComponent } from './components/analista/entidad/entidad.component';
import { GenerarComponent } from './components/analista/generar/generar.component';
import { GeneradosComponent } from './components/analista/generados/generados.component';
import { AsignadosComponent } from './components/analista/asignados/asignados.component';
import { InformesComponent } from './components/analista/informes/informes.component';
import { EstadisticasComponent } from './components/analista/estadisticas/estadisticas.component';
import { ConsultaComponent } from './components/analista/consulta/consulta.component';
import { RegistrarComponent } from './components/seleccionador/registrar/registrar.component';
import { ConsultarComponent } from './components/seleccionador/consultar/consultar.component';
import { NavSeleccionadorComponent } from './components/seleccionador/nav-seleccionador/nav-seleccionador.component';
import { NavAnalistaComponent } from './components/analista/nav-analista/nav-analista.component';


@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    ServiciosComponent,
    EntidadComponent,
    GenerarComponent,
    GeneradosComponent,
    AsignadosComponent,
    InformesComponent,
    EstadisticasComponent,
    ConsultaComponent,
    RegistrarComponent,
    ConsultarComponent,
    NavSeleccionadorComponent,
    NavAnalistaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }