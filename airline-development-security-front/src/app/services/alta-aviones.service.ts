import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AltaAviones } from '../interfaces/alta-aviones';


@Injectable()
export class AltaAvionesService {

  private URL:string = "http://back-airline-security.herokuapp.com/api/aircraft/";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  

  constructor(private http:HttpClient) { }

  
  saveAvion(avion:AltaAviones){
    
    return this.http.post(this.URL, JSON.stringify(avion),
    {
      headers:this.headers, 
      responseType: 'text'
     });            
  }

}
