import { Component, Input, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { WishlistService } from '../service/wishlist.service';
import { WishList } from '../models/wishlist.model';
import { CartService } from '../service/cart.service';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrl: './wishlist.component.css'
})
export class WishlistComponent implements OnInit{
  user: User;
  wishList: WishList[];

  loading = false;
  constructor(private wishService: WishlistService, private cartService: CartService
  ){}

  ngOnInit(): void {
    const user = JSON.parse(localStorage.getItem('user'));
    const userId = user.userId;

    if(userId !=null) {
      this.getWishlistByUser(userId);
      console.log(userId);
    }
  }

  getWishlistByUser(userId: number) {
    this.loading = true;
    this.wishService.getWishlistByUser(userId)
    .subscribe(res => {
      this.wishList = res;
      this.loading = false;
    })
      
  }

  deleteFromWishList(productId: number) {
    this.wishService.deleteProduct(productId)
    .subscribe(res =>{
      console.log("Delete successful");
      window.location.reload();
    })
  }

  sendToCart(product: Product) {
  this.cartService.addToCart(product);
  this.deleteFromWishList(product.productId);
  }
}
