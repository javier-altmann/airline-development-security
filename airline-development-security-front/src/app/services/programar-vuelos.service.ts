import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AvionesResponse } from '../interfaces/aviones-response';
import { RutasResponse } from '../interfaces/rutas-response';


@Injectable()
export class ProgramarVuelosService {

  constructor(public http: HttpClient) { }

  private URL:string  = 'http://localhost:3000';

  public getAvionesDisponibles(): Observable<AvionesResponse>{

   return this.http.get<AvionesResponse>(this.URL+'/avion');

  }

  public getRutas(): Observable<RutasResponse>{
    return this.http.get<RutasResponse>(this.URL+'/rutas')
    
  }


}


