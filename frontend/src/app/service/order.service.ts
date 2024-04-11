import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../models/order.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private API_URL = "http://localhost:8080/shoppingcart/orderhistory/";

  constructor(private http : HttpClient) { }

  createOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.API_URL}addproduct`, order)
  }

  getOrderHistoryByUser(userId: number) : Observable<Order[]> {
      return this.http.get<Order[]>(`${this.API_URL}users/${userId}`);
  }

}
