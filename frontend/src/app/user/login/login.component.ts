import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../../models/user.model';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  user: User;
  form: FormGroup;


  constructor(private fb: FormBuilder, private authService: AuthService,private router: Router) {

  }

  ngOnInit() {
    this.form = this.fb.group({
      email: [null, {
        validators: [Validators.required, Validators.email],
        updateOn: 'blur'
      }],
      password: [null, {
        validators: [Validators.required],
        updateOn: 'blur'
      }],
    });

  }

  login() {
    this.authService.login(this.form.value.email, this.form.value.password)
    .subscribe(res =>{
      this.router.navigate(['/home']);
    });

  }

  reset() {
    this.form.reset();
  }


  
}