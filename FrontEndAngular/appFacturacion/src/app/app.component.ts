import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UsuariosService} from './services/usuarios.service';
import {ProductosService} from './services/productos.service';
import { FacturaService } from './services/factura.service';
import { element } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  factura: any[] = [];
  productos: any[] = [];
  productosFiltrados: any[] = [];
  vendedores: any[] = [];
  pagos: any[] = [];
  cantAux: any[] = [];
  formImprimir: FormGroup;
    formFiltro: FormGroup;
    cliente: any;
    sum = 0;
formClient: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private servicioUsuarios: UsuariosService,
    private productosService: ProductosService,
    private facturaService: FacturaService) {
  this.formClient = this.formBuilder.group({
  clientId: [''],
  nameClient: [''],
})


this.productosService.get().subscribe(data => {
  this.productosFiltrados = data;
  this.productos = data;
} )




    this.formFiltro = this.formBuilder.group({
      producto: ['', Validators.required],
    });


    this.formFiltro.valueChanges.subscribe(data => {
      const producto = data.producto.toLowerCase();
      if (data.producto!=='') {
        const result = this.productos.filter(x => x.name.toLowerCase().substr(0, producto.length) === producto.substr(0, producto.length));
        this.productosFiltrados = result;
      }else{
        this.productosFiltrados = this.productos;
      }
    });
  }

  getClient(){

      this.servicioUsuarios.get(this.formClient.controls['clientId'].value).subscribe(data=>
        {
          if(data){
            this.formClient.controls['nameClient'].setValue(data.name+" "+data.lastName);
            this.cliente = data;
          }
        }, error => {
          if(error){
              console.log(error);
              alert(error.error);
              this.formClient.controls['nameClient'].setValue(" ");
          }

        });

  }

  createInvoice(){

    var request = {
      totalValue: 0,
      idClient: 0
      };

    request.totalValue = this.sum;
    request.idClient = this.cliente.idClient;
    alert(JSON.stringify(request));

    this.facturaService.createInvoice(request).subscribe(data => {
      if(data){
        this.createInvoiceDetail(data.responseInvoiceDTO);
      }
    })
  }

  createInvoiceDetail(detalle : any){

    let arreglo: any[] = [];


    this.factura.forEach(element =>{
      const itemFactura = {
      cantidad : parseInt(element.cant, 10),
      unitValue : element.unitValue,
      totalValue : element.precioTotal,
      idInvoice : detalle.idFactura,
      idProduct : parseInt(element.code, 10)
      }

      arreglo.push(itemFactura);
    })

    console.log(arreglo);
    this.facturaService.createInvoiceDetail(arreglo).subscribe(data => {
      if ( data){
          alert("Facturación terminada con éxito!");
          this.factura = [];
          this.sum = 0;
      }
    })

  }

  agregarItem(cant, item, precio) {
    console.log(cant, item, precio);
    if (cant > item.stock || cant < 1  || cant == null || cant === undefined) {
      alert('La cantidad seleccionada está fuera del rango del stock');
    } else {
    const itemFactura = {
      code: item.code,
      cant: cant,
      name: item.name,
      unitValue: item.unitValue,
      precioTotal: precio
    };

    this.factura.push(itemFactura);
    this.totalFactura(this.factura);
      }
  }

  totalFactura(factura:any){
    this.sum = 0;
    factura.forEach(element => {
      this.sum += element["precioTotal"];
    });
  alert(this.sum);
  }

  borrarItem(index) {
    this.factura.splice(index, 1);
    this.totalFactura(this.factura);

  }
}
