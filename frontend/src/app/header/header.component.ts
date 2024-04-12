import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { FormControl } from '@angular/forms';
import { Observable, startWith, map } from 'rxjs';
import { Product } from '../models/product.model';
import { ProductService } from '../product/product.service';
import { CartService } from '../service/cart.service';
import { Router } from '@angular/router';
import { AuthService } from '../user/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

  products:  Product[];
  cart : any;
  itemCount: number = 0;


  user: User;
 


  constructor(private cartService: CartService,
  public auth: AuthService,
     private router: Router) { }

  ngOnInit(): void {
 
    this.cartService.itemCount$
    .subscribe(count =>{
      this.itemCount = count;
    });

  
    this.auth.user$.subscribe(res =>
      this.user = res
    );
  }

logout() {
  this.auth.logout();
  this.router.navigate(['/home']);
  location.reload();
}


}
