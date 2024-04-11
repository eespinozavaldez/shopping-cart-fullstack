import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { EditComponent } from './edit/edit.component';
import { SignupComponent } from './signup/signup.component';
import { OrderComponent } from './order/order.component';
import { UserService } from './user.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { UserRoutingModule } from './user-routing.module';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AuthService } from './auth.service';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';




@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent,
    EditComponent,
    OrderComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatButtonModule,
    UserRoutingModule,
    MatPaginatorModule,
    MatProgressSpinnerModule
   
  ],
  providers: [
    UserService,
    AuthService
  ]
})
export class UserModule { }
