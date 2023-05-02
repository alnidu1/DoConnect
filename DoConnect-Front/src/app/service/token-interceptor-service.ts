
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import {Injectable} from '@angular/core'
import { Observable } from 'rxjs';
import { UserAuthService } from './user-auth-service';

@Injectable({
    providedIn:'root'
})
export class TokenInterceptorService implements HttpInterceptor{

    constructor(private userAuthService: UserAuthService) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       let token = this.userAuthService.getToken()
       
       if (req.url.includes('login') || req.url.includes('') ) {
        return next.handle(req);
      }
      if (req.url.includes('home')) {
        return next.handle(req);
      }
        let jwttoken = req.clone({
            setHeaders:{
                Authorization: 'Bearer ' + token
            }
        })
        return next.handle(jwttoken)
    
    }

}
