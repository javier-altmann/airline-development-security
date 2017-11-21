import { Component, OnInit, ViewChild } from '@angular/core';
import { AltaAvionesService } from '../../../services/alta-aviones.service';
import { AltaAviones } from '../../../interfaces/alta-aviones';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { DialogService } from 'ng2-bootstrap-modal';



@Component({
  selector: 'app-alta-aviones',
  templateUrl: './alta-aviones.component.html',
  
})
export class AltaAvionesComponent implements OnInit {
  form:FormGroup;
  flag:boolean = false;
  flagError:boolean = false;
 
  constructor(private _altaAvionesServices:AltaAvionesService, private formularioAlta:FormBuilder,
    dialogService: DialogService) {
  
  
      this.validacionesFormularioAltaDeAviones(formularioAlta);
  }
  validacionesFormularioAltaDeAviones(formulario:FormBuilder){
    this.form = formulario.group({
      brand:['', Validators.required],
      model:['', Validators.required],
      max_seats: ['', Validators.compose([
        Validators.required,
        Validators.maxLength(3)
      ])],
      registrationNumber:['', Validators.required] 
     })
  }
  ngOnInit() {

  }

  guardarAltaAvion(){
    
    const avionObject = <AltaAviones>this.form.value;
     avionObject.id_seat = Math.floor(Math.random()*900).toString();  
     avionObject.id_aircraft = Math.floor(Math.random()*900).toString();  

     this._altaAvionesServices.saveAvion(avionObject)
       .subscribe(data=>{
              this.flag = true;
              this.form.reset();
       },
        error=> 
        
        this.flagError = true);
  }

}
