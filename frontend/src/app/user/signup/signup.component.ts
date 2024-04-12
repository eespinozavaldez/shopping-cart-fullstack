import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { User } from '../../models/user.model';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { state } from '@angular/animations';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit {
  hide = true;
  newUser: any;
  form: FormGroup;

  constructor(private fb: FormBuilder , 
            private userService: UserService, 
            private router: Router) {
   
  }

  ngOnInit() {
    this.form = this.fb.group({
      name: [null, [Validators.required]],
      lastName: [null, [Validators.required]],
      bio: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
      areaOfInterest: [null, [Validators.required]]
    });
  }

  signup() {
    console.log(this.form.value);
    this.userService.signup(this.form.value)
      .subscribe((res) => {
       this.newUser = res;


      console.log("New User created");

      this.router.navigate(['/home']).then(()=> {
        window.location.reload();
      });

      });
  }


}
