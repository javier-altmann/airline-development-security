import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../interfaces/usuario';
import { LoginVm } from '../interfaces/login-vm';

@Injectable()
export class LoginService {
  private URL_LOGIN:string = "http://back-airline-security.herokuapp.com/api/login/";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')


  constructor(private http:HttpClient) { }

  login(usuario:Usuario){
    
    return this.http.post<LoginVm>(this.URL_LOGIN, JSON.stringify(usuario),{
      headers:this.headers
    });            
  }

}
