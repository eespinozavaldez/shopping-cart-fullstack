import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import {MatMenuModule} from '@angular/material/menu';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CartComponent } from './cart/cart.component';
import { CartService } from './service/cart.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {AsyncPipe} from '@angular/common';
import {MatBadgeModule} from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { HomeComponent } from './home/home.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { HeederComponent } from './heeder/heeder.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    WishlistComponent,
    CartComponent,
    PageNotFoundComponent,
    HomeComponent,
    HeederComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatButtonModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatMenuModule,
    MatAutocompleteModule,
    AsyncPipe,
    MatBadgeModule,
    MatIconModule,
    MatPaginatorModule,
    MatProgressSpinnerModule
    
  ],
  providers: [
    CartService,
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
