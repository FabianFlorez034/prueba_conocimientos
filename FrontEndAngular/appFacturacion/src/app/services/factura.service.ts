import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }


  //crear método
  createInvoice(request: any): Observable<any> {

    const endpoint = environment.factura;

    return this.http.post<any>(endpoint, request);
   }

    //crear método
  createInvoiceDetail(request: any[]): Observable<any> {

    const endpoint = environment.detalleFactura;

    return this.http.post<any>(endpoint, request);
   }
}
