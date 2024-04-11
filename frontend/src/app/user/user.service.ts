import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private API_URL = "http://localhost:8080/shoppingcart/users/";

  constructor(private http: HttpClient) { }


  signup(usarData: any): Observable<any> {
    return this.http.post(`${this.API_URL}add`,usarData)
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.API_URL}${userId}`);
  }

  updateUser(userId: number, usarData: any): Observable<User> {
    return this.http.put<User>(`${this.API_URL}${userId}`,usarData)
  }

  // login(email: string, password: string): Observable<any> {
  //   return this.http.post<any>(`${this.API_URL}login`, {email, password})
  // }
}
