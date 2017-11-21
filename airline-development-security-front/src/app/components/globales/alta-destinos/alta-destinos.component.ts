import { Component, OnInit } from '@angular/core';
import { AltaDestinos } from '../../../interfaces/alta-destinos';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AltaDestinosService } from '../../../services/alta-destinos.service';
import { DialogService } from 'ng2-bootstrap-modal';


@Component({
  selector: 'app-alta-destinos',
  templateUrl: './alta-destinos.component.html'
})
export class AltaDestinosComponent implements OnInit {
  form:FormGroup;
  flag:boolean = false;
  flagError:boolean = false;

  constructor(private _altaDestinosServices:AltaDestinosService, private formularioAlta:FormBuilder,
              private dialogService: DialogService) { 
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
          this.flag = true;
          this.form.reset();
       },
        error=> this.flagError = true);
  }


}
