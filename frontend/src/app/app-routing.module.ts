import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CartComponent } from './cart/cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './user/auth.guard';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: '/home',
      pathMatch: 'full'
  },
  {
    path: 'user',
    loadChildren: () => import('./user/user.module').then(m =>
      m.UserModule)
  },
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: 'products',
    loadChildren: () => import('./product/product.module').then(m =>
      m.ProductModule)
  },
  {
    path: 'wishlist',
    component: WishlistComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
