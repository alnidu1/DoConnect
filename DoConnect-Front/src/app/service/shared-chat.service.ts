import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedChatService {
  private stringSource = new BehaviorSubject<string>('');
  currentString = this.stringSource.asObservable();

  constructor() { }

  changeString(newString: string) {
    this.stringSource.next(newString);
  }

}
