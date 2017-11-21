import { Component, OnInit } from '@angular/core';
import { AltaRutasService } from '../../../services/alta-rutas.service';
import { Destinos } from '../../../interfaces/destinos';
import { AltaRutas } from '../../../interfaces/alta-rutas';
import { Observable } from 'rxjs/Observable';
import { strictEqual } from 'assert';
import { AltaDestinos } from '../../../interfaces/alta-destinos';


@Component({
  selector: 'app-alta-rutas',
  templateUrl: './alta-rutas.component.html'
})
export class AltaRutasComponent implements OnInit {
 destinos:Observable<AltaDestinos>;
 
 
  rutasObject:AltaRutas  = {
    id_itinerary: Math.floor(Math.random()*900).toString(),
    cost_ticket: '' ,
    id_from_destination: '',
    id_to_destination: ''

  }

  constructor(private _altaDestinosServices:AltaRutasService) { }
  
  

  

   
  ngOnInit() {
  this.destinos = this._altaDestinosServices.getDestinos();
 
  }

  guardarAltaRuta(){
    
    console.log(this.rutasObject);
    
    this._altaDestinosServices.saveRutas(this.rutasObject)
    .subscribe(data=>{
       console.log("subscribe ok");
    },
     error=> 
             console.log(error));
    }

  }




