import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Products } from './products';
import {Pagination } from './pagination';
import { Observable } from 'rxjs';
import { ApiResponse } from './apiResponse';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
    constructor(private httpClient: HttpClient){}
    url: string = "http://localhost:8080/Products/v1";

    public getAllProducts(): Observable<ApiResponse<Products[], Pagination>>{
      return this.httpClient.get<ApiResponse<Products[], Pagination>>(`${this.url}/all`)
    };

    public readProductById(id: number): Observable<Products>{
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
