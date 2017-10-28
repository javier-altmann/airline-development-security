import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AltaDestinos } from '../interfaces/alta-destinos';

@Injectable()
export class AltaDestinosService {

  private URL:string = "s";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')

  constructor(private http:HttpClient) { }

  saveDestinos(destinos:AltaDestinos){
    
    return this.http.post<AltaDestinos>(this.URL, JSON.stringify(destinos),{headers:this.headers});            
  }

}
