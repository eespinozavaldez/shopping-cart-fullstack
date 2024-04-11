import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../models/user.model';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent implements OnInit {
  user: User;
  form: FormGroup;
  

  constructor(private fb: FormBuilder,
     private userService: UserService,
    private route: ActivatedRoute) {

  }

  ngOnInit() {
   
    if (localStorage.getItem("user")) {
      this.user = JSON.parse(localStorage.getItem("user"));
    }
    const userId = this.user.userId;
    
    this.getUserById(userId);
    this.form = this.fb.group({
      bio: [this.user.bio],
      areaOfInterest: [this.user.areaOfInterest]
    });
  }

  getUserById(userId: number) {
    this.userService.getUserById(userId)
      .subscribe(user =>{
        this.user = user;
      });
  }


  updateUser(userId: number) {
    this.userService.updateUser(userId, this.form.value)
      .subscribe(user => {
        this.user = user;
        localStorage.setItem("user", JSON.stringify(this.user));
        window.location.reload();
        console.log(this.user);
  });
  }


}

