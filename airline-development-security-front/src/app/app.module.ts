import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule,FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

//Rutas
import {  APP_ROUTING } from './app.routes';

//Servicios
import { ProgramarVuelosService } from './services/programar-vuelos.service';
import { AltaAvionesService } from './services/alta-aviones.service';
import { AltaDestinosService } from './services/alta-destinos.service';
import { VentaTicketsService } from './services/venta-tickets.service';
import { AltaRutasService } from './services/alta-rutas.service';
import { LoginService } from './services/login.service';

//Componentes
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login/login.component';
import { LogoComponent } from './components/shared/logo/logo.component';
import { MenuAnalistaComponent } from './components/shared/menu-analista/menu-analista.component';
import { MenuVendedorComponent } from './components/shared/menu-vendedor/menu-vendedor.component';
import { AltaAvionesComponent } from './components/globales/alta-aviones/alta-aviones.component';
import { AltaDestinosComponent } from './components/globales/alta-destinos/alta-destinos.component';
import { ProgramarVuelosComponent } from './components/analista/programar-vuelos/programar-vuelos.component';
import { VentaTicketsComponent } from './components/vendedor/venta-tickets/venta-tickets.component';
import { CerrarVuelosComponent } from './components/vendedor/cerrar-vuelos/cerrar-vuelos.component';
import { MenuGlobalComponent } from './components/shared/menu-global/menu-global.component';
import { AltaRutasComponent } from './components/globales/alta-rutas/alta-rutas.component';

import { BootstrapModalModule } from 'ng2-bootstrap-modal';


import { AlertModule } from 'ngx-bootstrap/alert';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoComponent,
    MenuAnalistaComponent,
    MenuVendedorComponent,
    AltaAvionesComponent,
    AltaDestinosComponent,
    ProgramarVuelosComponent,
    VentaTicketsComponent,
    CerrarVuelosComponent,
    MenuGlobalComponent,
    AltaRutasComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    APP_ROUTING,
    RouterModule,
    BootstrapModalModule.forRoot ({container: document.body}),
    AlertModule.forRoot()
  ],
  providers: [ProgramarVuelosService, AltaAvionesService,AltaDestinosService, VentaTicketsService, AltaRutasService, LoginService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
