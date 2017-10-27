import { Component, OnInit } from '@angular/core';
import { ProgramarVuelosService  } from '../../../services/programar-vuelos.service';
import { Observable } from 'rxjs/Observable';
import { AvionesResponse } from '../../../interfaces/aviones-response';
import { RutasResponse } from '../../../interfaces/rutas-response';

@Component({
  selector: 'app-programar-vuelos',
  templateUrl: './programar-vuelos.component.html'
})
export class ProgramarVuelosComponent implements OnInit {

 private avion:Observable<AvionesResponse>;
 private ruta:Observable<RutasResponse>;

  constructor(private _programarVuelosService:ProgramarVuelosService) { }
 
  
  ngOnInit() {

   this.avion = this._programarVuelosService.getAvionesDisponibles()
   this.ruta = this._programarVuelosService.getRutas();
  

  }

}
