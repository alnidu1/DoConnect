import { AfterViewInit, Component, OnInit } from '@angular/core';
import { UserAuthService } from './service/user-auth-service';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { Location } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';
import { Question } from './model/question';
import { QuestionService } from './service/questionService';



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

  constructor(private userAuthService: UserAuthService, private router:Router, private location:Location, private cd: ChangeDetectorRef,
    private questionService:QuestionService
    ) {
    this.isLoggedIn$ = this.userAuthService.isLoggedIn$();
    this.userAuthService.isLoggedIn$().subscribe(
      isLoggedIn => {
        if (isLoggedIn) {
          this.username = this.userAuthService.getUserName();
        } else {
          this.username = "";
        }
      }
    );
    

  }

  ngOnInit(): void {
    this.username = this.userAuthService.getUserName();
  }
  ngAfterViewInit() {
   

  }

  onLogout() {
    this.userAuthService.clear();
  this.userAuthService.setIsLoggedIn(false);
  this.username = '';

  // Emit a new value to the username$ BehaviorSubject
  this.username$.next(this.username);

  // Manually trigger a change detection cycle
  this.cd.detectChanges();

  this.router.navigate(['/home']);



  }

  onChat() {
    if(this.username==(''|| null|| undefined)){
      this.router.navigate(['/home']);

    }
    else{
      this.router.navigate(['/chatlist']);

    }
  }

  homeButton(){
    if(this.username==''){
      this.router.navigate(['/home']);

    }
    else if (this.userAuthService.getUserUserType()=='admin') {
      this.router.navigate(['/adminpost']);

    } else {
      this.router.navigate(['/userpost']);

    }
  }
  
  searchText: string = '';

  searchTerm: string='';
  questions: Question[]=[];
  searchQuestion() {
    this.questionService.searchQuestion(this.searchTerm).subscribe(
      (response) => {
        this.questions = response;
        this.router.navigate(['/usersearch'], { state: { questions: this.questions } });
      },
      (error) => {
        console.log(error);
      }
    );
  }

  isUserPostPath(): boolean {
    return this.router.url.startsWith('/userpost');
  }
  
  isAdminPostPath(): boolean {
    return this.router.url.startsWith('/adminpost');
  }

}
