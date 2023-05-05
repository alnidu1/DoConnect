import { Component, OnInit } from '@angular/core';
import { Question } from '../model/question';
import { QuestionService } from '../service/questionService';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Subject } from 'rxjs';
import { Answer } from '../model/answer';
import { UserAuthService } from '../service/user-auth-service';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {
  user:User=new User(0,'','','','','','');
  questions:Question[]=[]
  question:Question=new Question(0, "", "", "", "", "", "", 0, 0,[])
  addNewQuestionFormVisible:boolean = false

  private readonly postAction$ = new Subject()

  ngOnInit(): void {
    this.loadPosts();
  }

  constructor(private questionService:QuestionService, router:Router, private datePipe: DatePipe, private authservice: UserAuthService,
    private userService:UserService
    ) {}

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

  getUserbyID(id:number){
    this.userService.getUserbyId(id).subscribe((data:User)=>
    this.user=data
    );
    
  }

  selectedQuestion: Question=new Question(0, "", "", "", "", "", "", 0, 0,[]);
  answers: Answer[] = [];
  answer: Answer = new Answer(0, '', '', '', '',0, 0, 0);

  addNewAnswerFormVisible:boolean = false

  addNewAnswer() {

    this.addNewAnswerFormVisible = !this.addNewAnswerFormVisible
  }
  showAnswer=false;
  showAnswers(question: Question) {
    this.showAnswer=!this.showAnswer;
    this.selectedQuestion = question;
    console.log(question.id);
    this.questionService.getAnswersForQuestion(question.id).subscribe((answers: Answer[]) => {
      this.answers = answers;
    });
    
  }

  userid='';
  createAnswer(q:Question, answerForm: NgForm) {
    this.userid=this.authservice.getUserId();
    this.answer.qcreated_by = parseInt(this.userid);
    this.answer.question_id = q.id;
    this.answer.description_answer = answerForm.value.description_answer;
    this.answer.datetime = this.datePipe.transform(new Date(), 'MM/dd/yyyy h:mm:ss');
    this.answer.status = 'pending';
  
    this.questionService.addAnswer(this.answer.question_id, this.answer).subscribe(() => {
      this.showAnswers(this.selectedQuestion);
    });
  
    this.answer = new Answer(0, '', '', '', '', 0, 0, 0);
    this.addNewAnswerFormVisible = false;
    answerForm.resetForm();
  
    alert('Your answer has been submitted and is now pending approval.');
  }
  
}

