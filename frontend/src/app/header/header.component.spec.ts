import { ComponentFixture, TestBed } from "@angular/core/testing";
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from "./header.component";
import { AuthService } from "../user/auth.service";
import { of } from "rxjs";

describe('HeaderComponent', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
          declarations: [HeaderComponent],
          providers: [AuthService],
          imports: [HttpClientModule]
        });
      });
    
    //   it('should create the app', () => {
    //     let fixture = TestBed.createComponent(HeaderComponent);
    //     let app = fixture.debugElement.componentInstance;
    //     expect(app).toBeTruthy();
    //   });

    
      it('should display the user name if user is logged in', () => {
        let fixture = TestBed.createComponent(HeaderComponent);
        let app = fixture.debugElement.componentInstance;
        let authService = fixture.debugElement.injector.get(AuthService);
        spyOnProperty(authService,'isLoggedIn$').and.returnValue(of(true));
        fixture.detectChanges();
        let compiled = fixture.debugElement.nativeElement;
        expect(compiled.querySelector('button').textContent).toContain(app.user.name);
      });
    
  });