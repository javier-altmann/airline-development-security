import { Component, OnInit } from '@angular/core';
import { AltaDestinos } from '../../../interfaces/alta-destinos';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AltaDestinosService } from '../../../services/alta-destinos.service';


@Component({
  selector: 'app-alta-destinos',
  templateUrl: './alta-destinos.component.html'
})
export class AltaDestinosComponent implements OnInit {
  form:FormGroup;
  constructor(private _altaDestinosServices:AltaDestinosService, private formularioAlta:FormBuilder) { 
    this.validacionesFormularioAltaDeDestinos(formularioAlta);
  }

  validacionesFormularioAltaDeDestinos(formulario:FormBuilder){
    this.form = formulario.group({
      name:['', Validators.required],
     })
  }

  ngOnInit() {
  }

  guardarAltaDestino(){
    
    const destinoObject = <AltaDestinos>this.form.value;
          destinoObject.id_destination = Math.floor(Math.random()*900).toString();  

 
     this._altaDestinosServices.saveDestinos(destinoObject)
       .subscribe(data=>{
          
       },
        error=> console.log("error en la petición "));
  }


}
