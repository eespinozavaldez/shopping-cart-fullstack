import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProductComponent } from "./product.component";
import { ProductDetailComponent } from "./product-detail/product-detail.component";

const routes: Routes = [

    {
        path: '',
       component: ProductComponent
    },
    {
        path: 'view-details-product/:productId',
        component: ProductDetailComponent
    },


];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [RouterModule],
    providers: [
    ]
})
export class ProductRoutingModule {

}