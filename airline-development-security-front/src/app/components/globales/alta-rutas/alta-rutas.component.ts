import { Component, OnInit } from '@angular/core';
import { AltaRutasService } from '../../../services/alta-rutas.service';
import { Destinos } from '../../../interfaces/destinos';
import { AltaRutas } from '../../../interfaces/alta-rutas';
import { Observable } from 'rxjs/Observable';
import { strictEqual } from 'assert';
import { AltaDestinos } from '../../../interfaces/alta-destinos';
import { DialogService } from 'ng2-bootstrap-modal';


@Component({
  selector: 'app-alta-rutas',
  templateUrl: './alta-rutas.component.html'
})
export class AltaRutasComponent implements OnInit {
 destinos:Observable<AltaDestinos>;
 flag:boolean = false;
 flagError:boolean = false;
 
 
  rutasObject:AltaRutas  = {
    id_itinerary: Math.floor(Math.random()*900).toString(),
    cost_ticket: '' ,
    id_from_destination: '',
    id_to_destination: ''

  }

  constructor(private _altaDestinosServices:AltaRutasService, dialogService: DialogService) { }
  
  
  borrarFormulario():void{
   this.rutasObject.cost_ticket = '',
   this.rutasObject.id_from_destination = '',
   this.rutasObject.id_to_destination = ''
   
  }
  

   
  ngOnInit() {
  this.destinos = this._altaDestinosServices.getDestinos();
 
  }

  guardarAltaRuta(){
    
    this._altaDestinosServices.saveRutas(this.rutasObject)
    .subscribe(data=>{
      this.flag = true;
       this.borrarFormulario();
    },
     error=> 
             this.flagError = true
             
            );
    }

  }




