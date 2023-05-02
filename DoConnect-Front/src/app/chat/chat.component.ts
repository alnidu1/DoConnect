import { Component } from '@angular/core';
import { io } from 'socket.io-client'; 


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  private socket: any;
  messages: string[] = [];
  newMessage: string = '';

  constructor() {
    
    this.socket = io('http://localhost:3000');
    this.socket.on('message', (data: string) => {
      this.messages.push(data);
    });
  }

  sendMessage() {
    this.socket.emit('message', this.newMessage);
    this.newMessage = '';
  }
}
