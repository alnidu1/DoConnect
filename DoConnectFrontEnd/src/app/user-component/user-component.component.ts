import { Component } from '@angular/core';
import { User } from '../model/user';
import { OnInit } from '@angular/core';
import { UserService } from '../service/User.service';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponent  implements OnInit{

  users:User[];
  model:User;

  constructor(private userService:UserService){
    this.users=[];
    this.model= new User('','','','');
}

ngOnInit(): void {
    this.loadUser();
}

  addUser(loginform:any): void {
    const newUser = new User(loginform.value.name,  loginform.value.username, loginform.value.password, loginform.value.email);
    console.log(newUser)
    this.userService.createUser(newUser)
      .subscribe(
        response => {
          console.log(response);
          this.loadUser();
        },
        error => {
          console.log(error);
        });

      
  }

  loadUser(){
    this.userService.readAllUser().subscribe(users=>{
      this.users=users;
    })
  }

}
