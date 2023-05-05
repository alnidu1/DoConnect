import { AfterViewInit, Component, OnInit } from '@angular/core';
import { UserAuthService } from './service/user-auth-service';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { Location } from '@angular/common';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  title = 'DoConnect-Front';


  isLoggedIn:boolean=false;
  isLoggedIn$: Observable<boolean> ;
  username:string=this.userAuthService.getUserName();
  username$ = new BehaviorSubject<string>('');
  constructor(private userAuthService: UserAuthService, private router:Router, private location:Location) {
    this.isLoggedIn$ = this.userAuthService.isLoggedIn$();
    

  }

  ngOnInit(): void {

   
    setTimeout(() => {
      this.username$.next(this.username);
    }, 100);
  
  }
  ngAfterViewInit() {
    //location.reload();
    

  }

  onLogout() {
    this.userAuthService.clear();

    this.userAuthService.setIsLoggedIn(false);
    this.username='';
    setTimeout(() => {
      this.username$.next(this.username);
    }, 10);
    //location.reload();

    this.router.navigate(['/home']);



  }

  onChat() {
    this.router.navigate(['/chatlist']);
  }

  searchText: string = '';

  search(){
    if (this.searchText) {
      this.router.navigate(['/usersearch'], { queryParams: { q: this.searchText } });
    }
  }

}
