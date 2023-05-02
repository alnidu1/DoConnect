import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user-component/user-component.component';
import { QuestionComponent } from './question/question.component';
import { AnswerComponent } from './answer/answer.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminRegistrationComponent,
    LoginComponent,
    UserComponent,
    QuestionComponent,
    AnswerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
