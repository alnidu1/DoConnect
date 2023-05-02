import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { Subscription } from 'rxjs';
import { UserAuthService } from '../service/user-auth-service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from '../service/user.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User(0,'','','','','','');
  errorMessage: string = '';
  subscription: Subscription=new Subscription();;

  constructor(private authService: UserAuthService, private router: Router, private userService:UserService) { }

  ngOnInit() {
  }

  login(loginForm:NgForm, username:any, password:any){
    
    this.userService.loginUser(loginForm.value).subscribe({
      next: (response: any) => {
        
        this.authService.setToken(response);

        let tokenInfo = this.authService.getDecodedAccessToken(response);
        console.log(tokenInfo);

        
        this.authService.setUser(tokenInfo.user);
        alert(username+ " Login Sucess");
        if (localStorage.getItem("user.userType") =="admin"){
          this.router.navigate(['adminpost']);
        } else {
          this.router.navigate(['userpost']);
        }



      },
      error :(error: HttpErrorResponse) => {
        
        this.authService.setToken(error.error.text);
        alert(error);
      }
  });
}

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
