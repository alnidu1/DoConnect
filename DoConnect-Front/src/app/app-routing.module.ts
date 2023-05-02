import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { UserPostComponent } from './user-post/user-post.component';
import { AdminPostComponent } from './admin-post/admin-post.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'signup', component: SignupComponent},
  {path: "userpost", component:UserPostComponent},
  {path: "adminpost", component:AdminPostComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
