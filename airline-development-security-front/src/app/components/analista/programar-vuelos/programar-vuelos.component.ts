import { Component, OnInit } from '@angular/core';
import { ProgramarVuelosService  } from '../../../services/programar-vuelos.service';
import { Observable } from 'rxjs/Observable';
import { AvionesResponse } from '../../../interfaces/aviones-response';
import { RutasResponse } from '../../../interfaces/rutas-response';
import { Vuelos } from '../../../interfaces/vuelos';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-programar-vuelos',
  templateUrl: './programar-vuelos.component.html'
})
export class ProgramarVuelosComponent implements OnInit {

 public avion:Observable<AvionesResponse>;
 public ruta:Observable<RutasResponse>;
 form:FormGroup;

  constructor(private _programarVuelosService:ProgramarVuelosService, private formularioVuelo:FormBuilder) {
     this.form = formularioVuelo.group({
      ruta:['', Validators.required],
      avion:['',Validators.required]
     })
   }
 
  
  ngOnInit() {

   this.avion = this._programarVuelosService.getAvionesDisponibles()
   this.ruta = this._programarVuelosService.getRutas();
  

  }

  guardarVuelo(){
    let vueloObject = <Vuelos>this.form.value;
    
        console.log(vueloObject);
         this._programarVuelosService.guardarVuelo(vueloObject)
           .subscribe(data=>{
              
           },
            error=> console.log("error en la petición "));
      }
}
