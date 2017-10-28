import { Component, OnInit } from '@angular/core';
import { VentaTicketsService } from '../../../services/venta-tickets.service';
import { VentaTickets } from '../../../interfaces/venta-tickets';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { RutasDisponiblesResponse } from '../../../interfaces/rutas-disponibles-response';
import { AsientosResponse } from '../../../interfaces/asientos-response';
import { Observable } from 'rxjs/Observable';



@Component({
  selector: 'app-venta-tickets',
  templateUrl: './venta-tickets.component.html'
})
export class VentaTicketsComponent implements OnInit {
  
  form:FormGroup;
  asientosDisponibles:Observable<AsientosResponse>;
  rutasDisponibles:Observable<RutasDisponiblesResponse>;

  constructor(private _altaAvionesServices:VentaTicketsService, private formularioVenta:FormBuilder) {
    this.validacionesFormularioVentaTickets(formularioVenta);
   }



  validacionesFormularioVentaTickets(formulario:FormBuilder){
    this.form = formulario.group({
      nombre:['', Validators.required],
      dni:['', Validators.required],
      asiento:['', Validators.required],
      ruta: ['', Validators.required] 
     })
  }
  
  ngOnInit() {
   this.asientosDisponibles  = this._altaAvionesServices.getAsientosDisponibles();
   this.rutasDisponibles =   this._altaAvionesServices.getRutasDisponibles();
  }

  guardarVentaTicket(){
    let ventaObject = <VentaTickets>this.form.value;
    
        console.log(ventaObject);
         this._altaAvionesServices.saveDestinos(ventaObject)
           .subscribe(data=>{
              
           },
            error=> console.log("error en la petición "));
      }
  }        




