import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private http: HttpClient) {

  }

  //crear método
  get(): Observable<any> {

   const endpoint= environment.productos;

   return this.http.get<any>(endpoint);
  }
}
