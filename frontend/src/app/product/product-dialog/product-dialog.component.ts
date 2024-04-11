import { Component, Inject, inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Product } from '../../models/product.model';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-product-dialog',
  templateUrl: './product-dialog.component.html',
  styleUrl: './product-dialog.component.css'
})
export class ProductDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public product: Product,
  private router: Router, private dialogRef: MatDialogRef<ProductDialogComponent>) {}

  viewDetails() {
    event?.preventDefault();
    this.router.navigate(['/products/view-details-product', this.product.productId]);
    this.dialogRef.close();
  }

}
