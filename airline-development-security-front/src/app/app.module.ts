import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//Rutas
import {  APP_ROUTING } from './app.routes';


//Componentes
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login/login.component';
import { LogoComponent } from './components/shared/logo/logo.component';
import { MenuAnalistaComponent } from './components/shared/menu-analista/menu-analista.component';
import { MenuVendedorComponent } from './components/shared/menu-vendedor/menu-vendedor.component';
import { AltaAvionesComponent } from './components/globales/alta-aviones/alta-aviones.component';
import { AltaDestinosComponent } from './components/globales/alta-destinos/alta-destinos.component';
import { ProgramarVuelosComponent } from './components/analista/programar-vuelos/programar-vuelos.component';
import { AnalisisGananciasComponent } from './components/analista/analisis-ganancias/analisis-ganancias.component';
import { VentaTicketsComponent } from './components/vendedor/venta-tickets/venta-tickets.component';
import { CerrarVuelosComponent } from './components/vendedor/cerrar-vuelos/cerrar-vuelos.component';
import { MenuGlobalComponent } from './components/shared/menu-global/menu-global.component';



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
    AnalisisGananciasComponent,
    VentaTicketsComponent,
    CerrarVuelosComponent,
    MenuGlobalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    APP_ROUTING
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
