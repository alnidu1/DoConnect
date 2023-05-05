import { Component, OnInit} from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { UserAuthService } from '../service/user-auth-service';
import { Router } from '@angular/router';
import { SharedChatService } from '../service/shared-chat.service';
@Component({
  selector: 'app-chatlist',
  templateUrl: './chatlist.component.html',
  styleUrls: ['./chatlist.component.css']
})
export class ChatlistComponent implements OnInit{
  users:User[];
  fromuser: string = this.userAuthService.getUserName();
  touser: string = "";


  constructor(private userAuthService:UserAuthService, private userService:UserService, private router:Router, private sharedChatService:SharedChatService){
    this.users=[];
  }
  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.userService.getAllUsers()
    .subscribe((data:User[])=>{
      this.users=data;
    })
  }

  openChat(name: string){
    this.touser = name;
    this.sharedChatService.changeString(this.touser);
    this.router.navigate(['/chat']);
  }

}
