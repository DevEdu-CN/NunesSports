import { Component, inject } from '@angular/core';
import { Products } from './products';
import { ProductService } from './product.service';
import { Pagination } from './pagination';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    productsList$: Products[] = [];

    constructor(private productsService: ProductService){
      this.productsService.getAllProducts().subscribe(response => {
        this.productsList$ = response.data;
      });
      
    }

  }
