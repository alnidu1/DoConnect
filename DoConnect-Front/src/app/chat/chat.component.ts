import { Component, OnInit} from '@angular/core';
import { Chat } from '../model/chat';
import { ChatService } from '../service/chat.service';
import { UserAuthService } from '../service/user-auth-service';
import { Router } from '@angular/router';
import { SharedChatService } from '../service/shared-chat.service';



@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit{
  chats: Chat[] = [];
  newMessage: string = '';
  fromuser: string = this.userAuthService.getUserName();
  touser: string = '';
  today = new Date();
  datetime:string = this.today.toLocaleDateString();
  ngOnInit(): void {
    this.sharedChatService.currentString.subscribe(touser => this.touser = touser);
    this.getAllChats();
  }

  constructor(private chatService:ChatService, router:Router, private userAuthService:UserAuthService, private sharedChatService:SharedChatService){}
  sendChat(message:string){
    let chat: Chat = new Chat(this.fromuser, this.touser, message, this.datetime)
    this.chatService.postChat(chat).subscribe(response => {
      console.log(response);
    });
    
    setTimeout(() => {this.getAllChats();}, 500);
  }

  getAllChats(){
    this.chatService.getAllMessages(this.fromuser, this.touser).subscribe((data: Chat[])=>{
      this.chats = data
    });
  }

}
