import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {


  constructor(private http: HttpClient) {

   }

   //crear método
   get(id: number): Observable<any> {

    const endpoint= environment.usuarios+id;

    return this.http.get<any>(endpoint);
   }
}
