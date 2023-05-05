import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { UserPostComponent } from './user-post/user-post.component';
import { AdminPostComponent } from './admin-post/admin-post.component';
import { ChatComponent } from './chat/chat.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { QuestionForumComponent } from './question-forum/question-forum.component';
import { ChatlistComponent } from './chatlist/chatlist.component';
import { ImageuploadComponent } from './imageupload/imageupload.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent},
  {path: "userpost", component:UserPostComponent},
  {path: "adminpost", component:AdminPostComponent},
  {path:"chat", component: ChatComponent},
  {path:"usersearch", component:UserSearchComponent},
  {path:"questionforum/:qId", component:QuestionForumComponent},
  {path:"usersearch", component:UserSearchComponent},
  {path: "chatlist", component: ChatlistComponent},
  {path: "image", component: ImageuploadComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
