import { Component, ElementRef } from '@angular/core';
import { io } from 'socket.io-client'; 
import { ViewChild} from '@angular/core';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  message: string = '';
  @ViewChild('messages', {static: true}) messages: ElementRef= new ElementRef("");

  constructor() { }

  ngOnInit(): void {
  }

  sendMessage(): void {
    if (this.message.trim() !== '') {
      const li = document.createElement('li');
      li.classList.add('list-group-item');
      li.innerText = this.message;
      this.messages.nativeElement.appendChild(li);
      this.message = '';
    }
  }
}
