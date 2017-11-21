import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AltaDestinos } from '../interfaces/alta-destinos';

@Injectable()
export class AltaDestinosService {

  private URL:string = "http://back-airline-security.herokuapp.com/api/destination/";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')

  constructor(private http:HttpClient) { }

  saveDestinos(destinos:AltaDestinos){
    
    return this.http.post(this.URL, JSON.stringify(destinos),{
      headers:this.headers,
      responseType: 'text'
    });            
  }

}
