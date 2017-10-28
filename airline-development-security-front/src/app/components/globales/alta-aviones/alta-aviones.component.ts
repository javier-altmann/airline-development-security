import { Component, OnInit } from '@angular/core';
import { AltaAvionesService } from '../../../services/alta-aviones.service';
import { AltaAviones } from '../../../interfaces/alta-aviones';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-alta-aviones',
  templateUrl: './alta-aviones.component.html',
  
})
export class AltaAvionesComponent implements OnInit {
  form:FormGroup;
 
 
  constructor(private _altaAvionesServices:AltaAvionesService, private formularioAlta:FormBuilder) {
    
      this.validacionesFormularioAltaDeAviones(formularioAlta);
  }
  validacionesFormularioAltaDeAviones(formulario:FormBuilder){
    this.form = formulario.group({
      marca:['', Validators.required],
      modelo:['', Validators.required],
      matricula:['', Validators.required],
      butacas: ['', Validators.compose([
        Validators.required,
        Validators.maxLength(3)
      ])] 
     })
  }
  ngOnInit() {

  }

  guardarAltaAvion(){
    
    let avionObject = <AltaAviones>this.form.value;

    console.log(avionObject);
     this._altaAvionesServices.saveAvion(avionObject)
       .subscribe(data=>{
          
       },
        error=> console.log("error en la petición "));
  }

}
