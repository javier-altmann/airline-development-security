import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule,FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


//Rutas
import {  APP_ROUTING } from './app.routes';

//Servicios
import { ProgramarVuelosService } from './services/programar-vuelos.service';
import { AltaAvionesService } from './services/alta-aviones.service';
import { AltaDestinosService } from './services/alta-destinos.service';

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
import { GananciasVuelosComponent } from './components/analista/ganancias-vuelos/ganancias-vuelos.component';
import { GananciasRutasComponent } from './components/analista/ganancias-rutas/ganancias-rutas.component';
import { GananciasTotalesComponent } from './components/analista/ganancias-totales/ganancias-totales.component';



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
    GananciasVuelosComponent,
    GananciasRutasComponent,
    GananciasTotalesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    APP_ROUTING,

  ],
  providers: [ProgramarVuelosService, AltaAvionesService,AltaDestinosService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
