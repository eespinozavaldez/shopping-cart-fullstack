import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable, map } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: 'root'
  })
export class AuthGuard implements CanActivate{
    constructor(private auth: AuthService,
        private router: Router) {

} 
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): 
    Observable<boolean | UrlTree> {
        return this.checkIfAuthenticated();
    }

    checkIfAuthenticated(): Observable<boolean | UrlTree> {
        return this.auth.isLoggedIn$
        .pipe(
            map(loggedIn =>
                loggedIn? true: this.router.parseUrl('user/login'))
        );
    }

}


