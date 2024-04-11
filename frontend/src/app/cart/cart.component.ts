import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';
import { Order } from '../models/order.model';
import { OrderService } from '../service/order.service';
import { User } from '../models/user.model';
import { Product } from '../models/product.model';
import { Router } from '@angular/router';
import { AuthService } from '../user/auth.service';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnInit {
  order: Order;
  cart: any;
  total: number = 0;

  loading = false;
  user: User;
  products: Product[];


  constructor(public cartService: CartService,
    public orderService: OrderService, private router: Router,
  public userService: UserService) {

  }

  ngOnInit(): void {
    this.loading = true;
    this.getCart();


  }

  getCart() {
    this.cart = this.cartService.getCart();
    this.getTotal();
    this.loading = false;
  }


  orderConfirme() {
    event?.preventDefault();
    this.router.navigate(['/user/orders']);
    this.createOrder();
    this.emptyCart()

  }

  createOrder() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.products = this.cartService.getCart();
    
    this.products.forEach(product => {
      const order: Order = {
        orderId: 1,
        orderDate: new Date(),
        user: this.user,
        product: product,
      }

      this.orderService.createOrder(order)
      .subscribe(res=>{
        console.log(res)
      })
    });

  

  }

  getTotal() {
    if (this.cart) {
      this.cart.forEach((product: { price: number, quantity: number; }) => {
        return this.total += product.quantity * product.price;
      });
    }
  }

  deleteFromCart(productId: number) {
    this.cartService.deleteFromCart(productId);
    window.location.reload();
  }

  emptyCart() {
    localStorage.removeItem('cart');
  }  

}
