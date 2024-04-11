import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { WishList } from '../models/wishlist.model';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  private API_URL = "http://localhost:8080/shoppingcart/wishlist/";

  
  constructor(private http : HttpClient) { }

  addToWishList(wishList: WishList): Observable<WishList> {
    return this.http.post<WishList>(`${this.API_URL}add`, wishList)
  }

  getWishlistByUser(userId: number): Observable<WishList[]> {
    return this.http.get<WishList[]>(`${this.API_URL}users/${userId}`);
  }

  deleteProduct(productId: number){
    return this.http.delete<WishList>(`${this.API_URL}removeproduct/${productId}`);
  }
}
