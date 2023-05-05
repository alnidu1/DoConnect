import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth-service';
import { Observable } from 'rxjs';
import { Chat } from '../model/chat';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private postChatUrl = "http://localhost:8080/chat/addchat"
  private getAllMessagesUrl = "http://localhost:8080/chat/getallchatbetweentwousers/"

  constructor(private http:HttpClient,
    private userAuthService: UserAuthService) {

     }

  requestHeader = new HttpHeaders({'No-Auth': 'True',
     'Content-Type' : 'application/json',
     'Accept' : '*/*',
     });


  getAllMessages(fromuser:string, touser:string):Observable<Chat[]> {
    let messageUrl = this.getAllMessagesUrl + fromuser + '/' + touser;
    return this.http.get<Chat[]>(`${messageUrl}`,{
      headers: this.requestHeader,
    });
  }

  postChat(chat:Chat){
    console.log('test');
    return this.http.post(`${this.postChatUrl}`, chat,{
      headers: this.requestHeader,
      responseType: 'json'
    });
  }
  
  
}
