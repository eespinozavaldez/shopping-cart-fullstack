import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: any = [];
  // cartItems: number = 1;
  itemExists: boolean = false;
  itemCart: any;

  constructor() {
    this.getCart();
  }

  getCart() {
    if (!localStorage.getItem("cart")) {
      localStorage.setItem("cart", JSON.stringify([]))
    }
    this.cart = JSON.parse(localStorage.getItem("cart"));
    return this.cart;
  }

  setlocalStorage() {
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  addToCart(product: Product) {
    const item = this.cart.find((item: { productId: number; }) => item.productId === product.productId);
    if(item) {
      console.log(item);
      item.quantity++;
      this.setlocalStorage();

    } else{
      this.cart.push({ ...product, quantity: 1 });
     this.setlocalStorage();
    }

    console.log(this.cart);
  }

  deleteFromCart(productId: number) {
    this.cart = this.cart.filter((item: { productId: number; }) => item.productId != productId);
     this.setlocalStorage();
  }


 

}
