import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Question } from '../model/question';
import { QuestionService } from '../service/questionService';
import { Router } from '@angular/router';
import { AnswerService } from '../service/answerService';
import { Answer } from '../model/answer';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
@Component({
  selector: 'app-pending-question',
  templateUrl: './pending-question.component.html',
  styleUrls: ['./pending-question.component.css']
})
export class PendingQuestionComponent implements OnInit{
  questions:Question[]=[]
  question:Question=new Question(0, "", "", "", "", "", "", new User(0,'','','','','',''), new User(0,'','','','','',''), [])
  answers:Answer[]=[]

  ngOnInit(): void {

    this.loadPosts();

  }
  


  constructor(private questionService:QuestionService, router:Router, private userService:UserService) {}

  loadPosts() {
    this.questionService.getPendingQuestions().subscribe((data: Question[])=>{
      this.questions=data
    });
    
  }

  approveQuestion(quest:Question){
    this.questionService.approveQuestion(quest).subscribe(()=>
      {
      this.loadPosts();
     });
  }

  denyQuestion(quest:Question){
    this.questionService.denyQuestion(quest).subscribe(()=>
    {
      this.loadPosts();
    }
    );
  }

  getUsernamebyID(id:number){
    console.log(this.userService.getUserById(id) + " "+ id)
    if(id!= (null || undefined)){
      this.userService.getUserById(id).subscribe((user: User)=>{
        
         return user.username;
      });
    }

    else{
      return "no Username";
    }
    return "no Username";

  }

 
}
