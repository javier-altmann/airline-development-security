import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login/login.component';
import { LogoComponent } from './Components/shared/logo/logo.component';
import { MenuAnalistaComponent } from './Components/shared/menu-analista/menu-analista.component';
import { MenuVendedorComponent } from './Components/shared/menu-vendedor/menu-vendedor.component';
import { AltaAvionesComponent } from './Components/globales/alta-aviones/alta-aviones.component';
import { AltaDestinosComponent } from './Components/globales/alta-destinos/alta-destinos.component';
import { PaginaPrincipalGlobalesComponent } from './Components/globales/pagina-principal-globales/pagina-principal-globales.component';
import { PaginaPrincipalAnalistaComponent } from './Components/analista/pagina-principal-analista/pagina-principal-analista.component';
import { ProgramarVuelosComponent } from './Components/analista/programar-vuelos/programar-vuelos.component';
import { AnalisisGananciasComponent } from './Components/analista/analisis-ganancias/analisis-ganancias.component';
import { VentaTicketsComponent } from './Components/vendedor/venta-tickets/venta-tickets.component';
import { CerrarVuelosComponent } from './Components/vendedor/cerrar-vuelos/cerrar-vuelos.component';
import { MenuGlobalComponent } from './Components/shared/menu-global/menu-global.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoComponent,
    MenuAnalistaComponent,
    MenuVendedorComponent,
    AltaAvionesComponent,
    AltaDestinosComponent,
    PaginaPrincipalGlobalesComponent,
    PaginaPrincipalAnalistaComponent,
    ProgramarVuelosComponent,
    AnalisisGananciasComponent,
    VentaTicketsComponent,
    CerrarVuelosComponent,
    MenuGlobalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
