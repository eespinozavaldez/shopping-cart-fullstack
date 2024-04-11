import { Component, OnInit, ViewChild } from '@angular/core';
import { Product } from '../models/product.model';
import { ProductService } from './product.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Observable, filter, tap } from 'rxjs';
import { ProductDialogComponent } from './product-dialog/product-dialog.component';
import { CartService } from '../service/cart.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { WishlistService } from '../service/wishlist.service';
import { WishList } from '../models/wishlist.model';
import { User } from '../models/user.model';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{
  products: Product[];
  wishList: WishList;
  cartItems: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  obs: Observable<any>;
  dataSource = new MatTableDataSource<Product>();
  @ViewChild(MatSort) sort: MatSort;

  loading = false;
  user: User;
  
  constructor(private productService: ProductService, 
    public dialog: MatDialog, public cartService: CartService,
    public wishService: WishlistService) {
  
  }

  ngOnInit(): void {
    this.getAllProducts();
    this.obs = this.dataSource.connect();
  }

  getAllProducts() {
    this.loading = true;
    this.productService.getProducts()
      .subscribe(products =>{
        this.onDataLoad(products);
        this.loading = false;
      });
  }

  openDialog(product: Product) {
    const dialogRef = this.dialog.open(ProductDialogComponent, {
      width: '300px',
      data: product
    });
  }

  addToCart(product: Product){
     this.cartService.addToCart(product);
  }

  addToWishList(product: Product){
  this.user = JSON.parse(localStorage.getItem('user'));

  const wishList: WishList = {
    wishId: 1,
    user: this.user,
    product: product
  }

  this.wishService.addToWishList(wishList)
  .subscribe(res => 
    console.log(res)
  );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onDataLoad(products: Product[]) {
    console.log(products);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.dataSource.data = products;
  }
}


