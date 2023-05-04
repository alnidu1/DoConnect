import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private userService:UserService, private router:Router){
  }
  ngOnInit(): void {
  }
  user:User = new User(
    0,
    "",
    "",
    "",
    "",
    "",
    ""
  );
  signup(signUpForm: NgForm){
    console.log(signUpForm.value);
    
    this.userService.createUser(signUpForm.value).subscribe((data:User)=>{
      console.log(data);
  });

  this.router.navigate(["/home"]);
  alert(signUpForm.value.userType+ " "+ signUpForm.value.username+ " create");
  };
  
}
