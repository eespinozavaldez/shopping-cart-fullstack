import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map, shareReplay, tap } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private API_URL = "http://localhost:8080/shoppingcart/users/";

  private subject = new BehaviorSubject<User>(null);

  user$ : Observable<User> = this.subject.asObservable();

  isLoggedIn$ : Observable<boolean>;
  isLoggedOut$ : Observable<boolean>;

  constructor(private http: HttpClient) { 
    this.isLoggedIn$ = this.user$.pipe(map(user => !!user));

        this.isLoggedOut$ = this.isLoggedIn$.pipe(map(loggedIn => !loggedIn));

        const user = localStorage.getItem('user');

        if (user) {
            this.subject.next(JSON.parse(user));
        }
  }


  login(email: string, password: string): Observable<User> {
    return this.http.post<User>(`${this.API_URL}login`, {email, password})
            .pipe(
                tap(user => {
                    this.subject.next(user);
                    localStorage.setItem('user', JSON.stringify(user));
                }),
                shareReplay()
            );
  }
  
  logout() {
    this.subject.next(null);
    localStorage.removeItem('user');
  }

}
