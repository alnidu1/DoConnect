import { Component } from '@angular/core';
import { QuestionService } from '../service/questionService';
import { Router} from '@angular/router';
import { Question } from '../model/question';
import { OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {
  questions: Question[]=[];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.questions = history.state.questions;
  }
}
  

