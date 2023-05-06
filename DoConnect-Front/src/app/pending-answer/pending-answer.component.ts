import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Question } from '../model/question';
import { QuestionService } from '../service/questionService';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { AnswerService } from '../service/answerService';
import { Answer } from '../model/answer';


@Component({
  selector: 'app-pending-answer',
  templateUrl: './pending-answer.component.html',
  styleUrls: ['./pending-answer.component.css']
})
export class PendingAnswerComponent implements OnInit{
  questions:Question[]=[]
  question:Question=new Question(0, "", "", "", "", "", "", 0, 0, [])
  answers:Answer[]=[]

  ngOnInit(): void {

    /*this.questionService.getAllQuestions().subscribe((data: Question[])=>{
      this.questions=data
    });*/
    this.loadPosts();

  }
  ngAfterViewInit() {


  }


  constructor(private questionService:QuestionService, router:Router, location:Location, private answerService:AnswerService) {}

  loadPosts() {
    
    this.answerService.getPendingAnswers().subscribe((data: Answer[]) => {
      this.answers = data
    })
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

  approveAnswer(answer:Answer) {
    this.answerService.approveAnswer(answer).subscribe(() => {
      this.loadPosts()
    })
  }

  denyAnswer(answer:Answer) {
    this.answerService.denyAnswer(answer).subscribe(() => {
      this.loadPosts()
    })
  }

  refresh(){
    location.reload;
  }
}
