import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductComponent } from './product.component';
import { DialogModule } from '@angular/cdk/dialog';
import { ProductService } from './product.service';
import { FormsModule } from '@angular/forms';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { ProductRoutingModule } from './product-routing.module';




@NgModule({
  declarations: [  
    ProductComponent,
    ProductDetailComponent
  ],
  imports: [
    CommonModule,
    DialogModule,
    FormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatProgressSpinnerModule,
    ProductRoutingModule

  ],
  providers: [
    ProductService
  ]
})
export class ProductModule { }
