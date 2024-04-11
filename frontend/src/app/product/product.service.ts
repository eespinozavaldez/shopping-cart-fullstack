import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Product } from "../models/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private API_URL = "http://localhost:8080/shoppingcart/products/";

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API_URL}all`);
  }


  getProductById(productId: number): Observable<Product> {
    return this.http.get<Product>(`${this.API_URL}${productId}`);
  }
}