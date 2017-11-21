import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../services/login.service';
import { Usuario } from '../../../interfaces/usuario';
import 'rxjs/add/operator/pluck';
import 'rxjs/add/operator/map';
import { LoginVm } from '../../../interfaces/login-vm';
import { Router } from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit {

  usuarioObject:Usuario  = {
    username:'',
    password:''

  }
  result:string; 


  constructor(private _altaAvionesServices:LoginService, private router:Router) {

   }

  ngOnInit() {
  }

  peticionLogin(){
   
    
    this._altaAvionesServices.login(this.usuarioObject).map(response => 
    this.result = response.authorization
    
    )
    .subscribe(data=>{
      
      if(this.result == 'admin'){
       
        this.router.navigate(['/alta-aviones']);
      }else if(this.result == 'vendedor'){
        this.router.navigate(['/venta-tickets']);
        
      }else if(this.result == 'analista'){
        this.router.navigate(['/programar-vuelos']);
       
      }
    },
     error=> 
             console.log(error));
    }
  }


