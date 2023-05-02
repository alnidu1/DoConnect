import { Component, OnInit } from '@angular/core';
import { Question } from '../model/question';
import { QuestionService } from '../service/questionService';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {
  
  questions:Question[]=[]
  question:Question=new Question(0, "", "", "", "", "", "", 0, 0)
  
  ngOnInit(): void {
    
    this.questionService.getAllQuestions().subscribe((data: Question[])=>{
      this.questions=data
    });
  }

  constructor(private questionService:QuestionService, router:Router) {}

  loadPosts() {
    this.questionService.getAllQuestions().subscribe((data: Question[])=>{
      this.questions=data
    });
  }
}
