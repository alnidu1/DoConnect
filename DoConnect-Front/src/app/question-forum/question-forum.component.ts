import {Component, Inject, OnInit} from '@angular/core'
import { Question } from '../model/question';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from '../service/questionService';
import { Answer } from '../model/answer';
import { AnswerService } from '../service/answerService';
import { NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { UserAuthService } from '../service/user-auth-service';
import { UserService } from '../service/user.service';

@Component({
    selector:'app-question-forum',
    templateUrl:'./question-forum.component.html',
    styleUrls: ['./question-forum.component.css']
})
export class QuestionForumComponent implements OnInit {
    public qId: any = 0
    public answer: Answer = new Answer(0, "", "", "", "", 0, 0, 0);
    public answers: Answer[] = []
    public question: any = new Question(0, "", "", "", "", "", "", 0, 0, this.answers);
    
    
    addNewAnswerFormVisible = false

    constructor(private _Activatedroute: ActivatedRoute, private questionService: QuestionService, 
        @Inject(AnswerService) private answerService: AnswerService, private datePipe: DatePipe, 
        private userAuthService:UserAuthService, private userService:UserService) {
    }
    ngOnInit(): void {
        this._Activatedroute.paramMap.subscribe((paramMap) => {
            this.qId = Number(paramMap.get('qId'))
        })
        console.log(this.qId)
        this.loadQuestion()
        this.loadAnswers()
    }

    addNewAnswer() {
        this.addNewAnswerFormVisible = !this.addNewAnswerFormVisible
    }

    loadQuestion() {
        this.questionService.getQuestionById(this.qId).subscribe((data: Question) => {
            this.question = data
        })
    }

    loadAnswers() {
        this.answerService.getApprovedAnswers(this.qId).subscribe((data: Answer[]) => {
            this.answers = data
        })
    }

    submitNewAnswer(newAnswerForm: NgForm) {
        newAnswerForm.value.datetime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss')
        newAnswerForm.value.status = "pending"
        newAnswerForm.value.question_id = this.qId

        this.answerService.addAnswer(newAnswerForm.value).subscribe(() => {
            this.loadAnswers()
        })
        this.addNewAnswerFormVisible = false
        alert("Your answer has been submitted and is now pending for approval.")
    }
}