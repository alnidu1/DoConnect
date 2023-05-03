import { Component } from '@angular/core';
import { UserAuthService } from './service/user-auth-service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DoConnect-Front';
  isLoggedIn:boolean=false;
  isLoggedIn$: Observable<boolean> ;
  username:string=this.userAuthService.getUserName();
  constructor(private userAuthService: UserAuthService, private router:Router) {
    this.isLoggedIn$ = this.userAuthService.isLoggedIn$();
    

  }

  ngOnInit(): void {

  }

  onLogout() {
    this.userAuthService.clear();

    this.userAuthService.setIsLoggedIn(false);

    this.router.navigate(['/home']);

  }

}
