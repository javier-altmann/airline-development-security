import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AvionesResponse } from '../interfaces/aviones-response';
import { RutasResponse } from '../interfaces/rutas-response';
import { HttpHeaders } from '@angular/common/http';
import { Vuelos  } from '../interfaces/vuelos';


@Injectable()
export class ProgramarVuelosService {

  constructor(public http: HttpClient) { }

  private URL:string  = 'http://localhost:3000';
  private URL_POST:string = "s";
  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')

  public getAvionesDisponibles(): Observable<AvionesResponse>{

   return this.http.get<AvionesResponse>(this.URL+'/avion');

  }

  public getRutas(): Observable<RutasResponse>{
    return this.http.get<RutasResponse>(this.URL+'/rutas')
    
  }
  
  public guardarVuelo(vuelo:Vuelos){
   
    return this.http.post<Vuelos>(this.URL_POST, JSON.stringify(vuelo),{headers:this.headers})
  }

}


