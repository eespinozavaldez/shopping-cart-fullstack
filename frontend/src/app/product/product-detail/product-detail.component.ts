import { Component, EventEmitter, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';
import {MatDialog,  MatDialogConfig} from '@angular/material/dialog';
import { ProductDialogComponent } from '../product-dialog/product-dialog.component';
import { filter, tap } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit {
 
 public product: Product;


  constructor(private route: ActivatedRoute, private productService: ProductService) {}
  
  ngOnInit(): void {
  
    const productId = this.route.snapshot.paramMap.get('productId');
    this.getProductById(Number(productId));
  
  }


  getProductById(productId : number) {
    this.productService.getProductById(productId)
      .subscribe(product =>
        this.product = product);
  }
}
