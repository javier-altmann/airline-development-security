import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login/login.component';
import { AltaAvionesComponent } from './components/globales/alta-aviones/alta-aviones.component';
import { AltaDestinosComponent  } from './components/globales/alta-destinos/alta-destinos.component';
import { ProgramarVuelosComponent } from './components/analista/programar-vuelos/programar-vuelos.component';
import { CerrarVuelosComponent  } from './components/vendedor/cerrar-vuelos/cerrar-vuelos.component';
import {  VentaTicketsComponent } from './components/vendedor/venta-tickets/venta-tickets.component';
import {  AltaRutasComponent } from './components/globales/alta-rutas/alta-rutas.component';




const APP_ROUTES: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'alta-aviones', component: AltaAvionesComponent },
  { path: 'alta-destinos', component: AltaDestinosComponent },
  { path: 'programar-vuelos', component: ProgramarVuelosComponent },
  { path: 'cerrar-vuelos', component: CerrarVuelosComponent  },
  { path: 'venta-tickets', component: VentaTicketsComponent  },
  { path: 'alta-rutas', component: AltaRutasComponent  },
  
  { path: '**', pathMatch:'full', redirectTo: 'login' }
];


export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);



