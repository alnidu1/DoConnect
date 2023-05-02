import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { question } from '../model/question';

import { QuestionService } from '../service/question.service';



@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{

  questions: question[]=[];
  qmodel:question= new question('','','','','','');

  constructor(private qservice:QuestionService){

  }

  ngOnInit(): void {
      this.qservice.readAllQuestion().subscribe(
        (response)=>{
          this.questions=response;
        }
      )
  }


  addQuestion(qform:any): void {
    const newQuestion = new question(qform.value.title,qform.value.description_question, qform.value.img_src, qform.value.datetime, qform.value.status, qform.value.topic);
    console.log(newQuestion)
    this.qservice.createQuestion(newQuestion)
      .subscribe(
        response => {
          console.log(response);
          this.qservice.readAllQuestion().subscribe(
            (response)=>{
              this.questions=response;
            }
          )
        },
        error => {
          console.log(error);
        });
        
        
  }



}
