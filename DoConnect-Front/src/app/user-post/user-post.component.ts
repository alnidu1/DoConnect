import { Component, OnInit } from '@angular/core';
import { Question } from '../model/question';
import { QuestionService } from '../service/questionService';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  questions:Question[]=[]
  question:Question=new Question(0, "", "", "", "", "", "", 0, 0)
  addNewQuestionFormVisible:boolean = false

  private readonly postAction$ = new Subject()

  ngOnInit(): void {
    this.loadPosts();
  }

  constructor(private questionService:QuestionService, router:Router, private datePipe: DatePipe) {}

  loadPosts() {
     //this.questionService.getAllQuestions().subscribe((data: Question[])=>{
     //  this.questions=data
     //});

    this.questionService.getApprovedQuestions().subscribe((data: Question[])=>{
      this.questions=data
    });
  }

  addNewQuestion() {
    this.addNewQuestionFormVisible = !this.addNewQuestionFormVisible
  }

  submitNewQuestion(newQuestionForm: NgForm) {
    newQuestionForm.value.datetime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss')
    newQuestionForm.value.status = "pending"
    
    this.questionService.addQuestion(newQuestionForm.value).subscribe(()=>{
      this.loadPosts()
    })
    this.addNewQuestionFormVisible = false
    this.loadPosts()
    alert("Your question has been submitted and is now pending approval.")
  }
}
