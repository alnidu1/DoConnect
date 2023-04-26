import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user-component/user-component.component';

const routes: Routes = [
  {path:"adminlogin", component: LoginComponent},
  {path:"adminregister", component: AdminRegistrationComponent},
  {path:"user", component:UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 


}
