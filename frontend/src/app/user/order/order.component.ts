import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../service/order.service';
import { Order } from '../../models/order.model';
import { UserService } from '../user.service';
import { User } from '../../models/user.model';
import { CartService } from '../../service/cart.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent  implements OnInit{
  orders : Order[];
  user : User;
  total: number = 0;
  loading = false;

  constructor(public orderService: OrderService, public userService: UserService,
    public cartService: CartService) {}

  ngOnInit(): void {
    const user = JSON.parse(localStorage.getItem('user'));
    const userId = user.userId;

    console.log(userId);

    if(userId !=null) {
      this.loading = true;
      this.getOrderHistoryByUser(userId);
    }
  
  }


  getOrderHistoryByUser(userId: number) {
    this.orderService.getOrderHistoryByUser(userId).subscribe(res => {
      this.orders = res;
      this.getTotal();
      this.loading = false;
    });
  }

  getTotal() {
    if (this.orders) {
      this.orders.forEach(order=> {
          this.total += order.product.price;
      });
     }
     return this.total; 
  }
}

