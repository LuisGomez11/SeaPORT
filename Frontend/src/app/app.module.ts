import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule}from '@angular/forms';

// IMPORTACION DEL MODULO DE RUTAS
import { AppRoutingModule } from './app-routing.module';

// IMPORTACION DE COMPONENTES
import { AppComponent } from './app.component';
import { InicioAnaComponent } from './components/analista/inicio/inicio.component';
import { ServiciosComponent } from './components/analista/servicios/servicios.component';
import { EntidadComponent } from './components/analista/entidad/entidad.component';
import { GeneradosComponent } from './components/analista/generados/generados.component';
import { AsignadosComponent } from './components/analista/asignados/asignados.component';
import { InformesComponent } from './components/analista/informes/informes.component';
import { EstadisticasComponent } from './components/analista/estadisticas/estadisticas.component';
import { RegistrarComponent } from './components/seleccionador/registrar/registrar.component';
import { ConsultarComponent } from './components/seleccionador/consultar/consultar.component';
import { NavAnalistaComponent } from "./components/analista/nav-analista/nav-analista.component";
import { NavSeleccionadorComponent } from './components/seleccionador/nav-seleccionador/nav-seleccionador.component';
import { EditComponent } from './components/analista/servicios/edit/edit.component';
import { ErrorComponent } from './components/error/error/error.component';
import { LoginComponent } from './components/login/login.component';
import { InicioComponent } from './components/inicio/inicio.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioAnaComponent,
    ServiciosComponent,
    EntidadComponent,
    GeneradosComponent,
    AsignadosComponent,
    InformesComponent,
    EstadisticasComponent,
    RegistrarComponent,
    ConsultarComponent,
    NavSeleccionadorComponent,
    NavAnalistaComponent,
    EditComponent,
    ErrorComponent,
    LoginComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
