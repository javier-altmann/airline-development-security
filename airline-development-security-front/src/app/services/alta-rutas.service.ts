import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { AltaRutas } from '../interfaces/alta-rutas';
import { Destinos } from '../interfaces/destinos';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AltaRutasService {

  private URL_ITINERARY:string = "http://back-airline-security.herokuapp.com/api/itinerary/";
  private URL_GET_DESTINATIONS = "http://back-airline-security.herokuapp.com/api/destinations/";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  

  constructor(private http:HttpClient) { }

  getDestinos(): Observable<Destinos>{
    return this.http.get<Destinos>(this.URL_GET_DESTINATIONS);

  }
  saveRutas(ruta:AltaRutas){
   return this.http.post(this.URL_ITINERARY,JSON.stringify(ruta),
    {
      headers:this.headers, 
      responseType: 'text'
    });
  
  }

}
