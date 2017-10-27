import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login/login.component';
import { AltaAvionesComponent } from './components/globales/alta-aviones/alta-aviones.component';
import { AltaDestinosComponent  } from './components/globales/alta-destinos/alta-destinos.component';
import { GananciasVuelosComponent  } from './components/analista/ganancias-vuelos/ganancias-vuelos.component';
import { GananciasRutasComponent  } from './components/analista/ganancias-rutas/ganancias-rutas.component';
import { GananciasTotalesComponent  } from './components/analista/ganancias-totales/ganancias-totales.component';
import { ProgramarVuelosComponent } from './components/analista/programar-vuelos/programar-vuelos.component';
import { CerrarVuelosComponent  } from './components/vendedor/cerrar-vuelos/cerrar-vuelos.component';
import {  VentaTicketsComponent } from './components/vendedor/venta-tickets/venta-tickets.component';




const APP_ROUTES: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'altaAviones', component: AltaAvionesComponent },
  { path: 'altaDestinos', component: AltaDestinosComponent },
  { path: 'gananciasPorVuelo', component: GananciasVuelosComponent   },
  { path: 'gananciasPorRuta', component: GananciasRutasComponent  },
  { path: 'gananciasTotales', component:GananciasTotalesComponent  },
  { path: 'programarVuelos', component: ProgramarVuelosComponent },
  { path: 'cerrarVuelos', component: CerrarVuelosComponent  },
  { path: 'ventaTickets', component: VentaTicketsComponent  },
  
  { path: '**', pathMatch:'full', redirectTo: 'login' }
];


export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);



