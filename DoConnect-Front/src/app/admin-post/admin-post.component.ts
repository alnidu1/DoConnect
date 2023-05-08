import { Component } from '@angular/core';


@Component({
  selector: 'app-admin-post',
  templateUrl: './admin-post.component.html',
  styleUrls: ['./admin-post.component.css']
})
export class AdminPostComponent {

  showQuestions: boolean = true; // set initial value to true
  showAnswers: boolean = false;


  ngOnInit(): void {
    // fetch data if needed
  }

  toggleQuestions() {
    this.showQuestions = true;
    this.showAnswers = false;
  }

  toggleAnswers() {
    this.showAnswers = true;
    this.showQuestions = false;
  }
}
