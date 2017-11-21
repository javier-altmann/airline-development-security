import { Component, OnInit } from '@angular/core';
import { ProgramarVuelosService  } from '../../../services/programar-vuelos.service';
import { Observable } from 'rxjs/Observable';
//import { RutasResponse } from '../../../interfaces/rutas-response';
import { Vuelos } from '../../../interfaces/vuelos';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Itinerary } from '../../../interfaces/itinerary';
import { Aircraft } from '../../../interfaces/aircraft';
import { VueloVm } from '../../../interfaces/vuelo-vm';
import { DialogService } from 'ng2-bootstrap-modal';

@Component({
  selector: 'app-programar-vuelos',
  templateUrl: './programar-vuelos.component.html'
})
export class ProgramarVuelosComponent implements OnInit {

 public aircrafts:Observable<Aircraft>;
 public itinerarys:Observable<Itinerary>;
 flag:boolean = false;
 flagError:boolean = false;
 
 vueloObject:VueloVm = {
  id_flight : Math.floor(Math.random()*900).toString(),
  id_aircraft : '',
  id_itinerary : '',
  id_passenger_list : '1'
 }

  constructor(private _programarVuelosService:ProgramarVuelosService, dialogService: DialogService) { }
 
  
  ngOnInit() {

   this.itinerarys = this._programarVuelosService.getItinerary();
   this.aircrafts = this._programarVuelosService.getAircraft();
  

  }

  limpiarFormulario():void{
    this.vueloObject.id_itinerary = '',
    this.vueloObject.id_aircraft = ''
  }

  guardarVuelo(){
   
         this._programarVuelosService.guardarVuelo(this.vueloObject)
           .subscribe(data=>{
             this.flag = true;
             this.limpiarFormulario();              
           },
            error=> this.flagError = true);
      }
}
