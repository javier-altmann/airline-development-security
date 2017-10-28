import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AltaAviones } from '../interfaces/alta-aviones';


@Injectable()
export class AltaAvionesService {

  private URL:string = "s";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  

  constructor(private http:HttpClient) { }

  
  saveAvion(avion:AltaAviones){
    
    return this.http.post<AltaAviones>(this.URL, JSON.stringify(avion),{headers:this.headers});            
  }

}
