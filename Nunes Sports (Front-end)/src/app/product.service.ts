import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Products } from './products';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
    constructor(private httpClient: HttpClient){}
    url: string = "http://localhost:8080/Products/v1";

    public getAllProducts(): Observable<Products[]>{
      return this.httpClient.get<Products[]>(`${this.url}`);
    };

    public readProduct(id: number): Observable<Products>{
      return this.httpClient.get<Products>(`${this.url}/find/${id}`);
    }

    public createProduct(product: Products): Observable<Products>{
     return this.httpClient.post<Products>(`${this.url}/add`, product);
    }

    public updateProduct(url: string, product: Products): Observable<Products>{
      return this.httpClient.put<Products>(`${this.url}/update/${product.id}`, product);
    }

    public deleteProduct(id:number): Observable<Products>{
      return this.httpClient.delete<Products>(`${this.url}/delete/${id}`);
    }

}
