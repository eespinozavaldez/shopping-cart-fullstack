import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { OrderComponent } from "./order/order.component";
import { EditComponent } from "./edit/edit.component";
import { AuthGuard } from "./auth.guard";


const routes: Routes = [

    {
        path: '',
        redirectTo: 'login',
        pathMatch: "full"
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: LoginComponent
    },
    {
        path: 'orders',
        component: OrderComponent,
        canActivate: [AuthGuard]
    },
    {
        path: 'profile',
        component: EditComponent,
        canActivate: [AuthGuard]
    },


];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [RouterModule],
    providers: [
        //   CourseResolver,
        //   AuthGuard
    ]
})
export class UserRoutingModule {

}