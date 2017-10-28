import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { AsientosResponse } from '../interfaces/asientos-response';
import { RutasDisponiblesResponse } from '../interfaces/rutas-disponibles-response';
import { VentaTickets } from '../interfaces/venta-tickets';



@Injectable()
export class VentaTicketsService {

  constructor(public http:HttpClient) { }

  private URL_POST:string = "s";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  private URL:string  = 'http://localhost:3000';
  
    public getAsientosDisponibles(): Observable<AsientosResponse>{
  
     return this.http.get<AsientosResponse>(this.URL+'/asientosDisponibles');
  
    }
  
    public getRutasDisponibles(): Observable<RutasDisponiblesResponse>{
      
      return this.http.get<RutasDisponiblesResponse>(this.URL+'/rutasDisponibles')
      
    }

    public saveDestinos(destinos:VentaTickets){
      
      return this.http.post<VentaTickets>(this.URL_POST, JSON.stringify(destinos),{headers:this.headers});            
    }


}
