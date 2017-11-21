import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { Vuelos  } from '../interfaces/vuelos';
import { Aircraft } from '../interfaces/aircraft';
import { Itinerary } from '../interfaces/itinerary';


@Injectable()
export class ProgramarVuelosService {

  constructor(public http: HttpClient) { }

  private URL_AIRCRAFT:string  = 'http://back-airline-security.herokuapp.com/api/aircrafts/';
  private URL_POST:string = 'http://back-airline-security.herokuapp.com/api/flight/schedule/';
  private URL_ITINERARY = 'http://back-airline-security.herokuapp.com/api/itineraries/';

  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')

  public getAircraft(): Observable<Aircraft>{

   return this.http.get<Aircraft>(this.URL_AIRCRAFT);

  }

  
  public getItinerary (): Observable<Itinerary>{
    
       return this.http.get<Itinerary>(this.URL_ITINERARY);
    
      }

  public guardarVuelo(vuelo:Vuelos){
   
    return this.http.post(this.URL_POST, JSON.stringify(vuelo),
    {
      headers:this.headers, 
      responseType: 'text'
    })
  }

}


