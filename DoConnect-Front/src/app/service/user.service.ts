import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../model/user";
import { UserAuthService } from "./user-auth-service";

@Injectable({
    providedIn:"root"
})

export class UserService{
    private baseUrl="http://localhost:8080/api/User";

    private postUrl="http://localhost:8080/api/User/post";
    private getUrl="http://localhost:8080/api/User/get";
    private putUrl="http://localhost:8080/api/User/put";
    private deleteUrl="http://localhost:8080/api/User/delete";

    private signupUserUrl = "http://localhost:8080/adduser";
    private authenticateUrl = "http://localhost:8080/authenticate";
    private getAllUsersUrl = "http://localhost:8080/getallusers";
    private updateUserUrl = "http://localhost:8080/updateuser";
    private getLoginUrl = "http://localhost:8080/getlogin";
    private userLoginVerifyUrl = "http://localhost:8080/userloginverify";
    private getallusersUrl = "http://localhost:8080/getallusers";
    private getallusersbyidUrl = "http://localhost:8080/getallusersbyid";
    private getallusersbyname = "http://localhost:8080/getallusersbyname";
    private getallusersbytype = "http://localhost:8080/getallusersbytype";


    constructor(private http:HttpClient,
                private userAuthService: UserAuthService){

    }

   
    createUser(user:User):Observable<User>{
        return this.http.post<User>(`${this.signupUserUrl}`,user);
    }

    requestHeader = new HttpHeaders({'No-Auth': 'True',
        'Content-Type' : 'application/json',
        'Accept' : '*/*',
        });


    loginUser(loginData:any):Observable<any>{
        return this.http.post(this.authenticateUrl, loginData,{
            headers: this.requestHeader,
            'responseType': 'text'
        });
    }

    getAllUsers():Observable<User[]>{
        return this.http.get<User[]>(`${this.getAllUsersUrl}`,{
            headers: this.requestHeader,
        });
    }


    public roleMatch(allowedRoles:any): boolean {
        let isMatch:boolean = false;
        const userRoles: any = this.userAuthService.getRoles();
        if (userRoles != null && userRoles) {
            for (let j = 0; j < allowedRoles.length; j++) {
              if (userRoles.userType === allowedRoles[j]) {
                isMatch = true;
                return isMatch;
              } else {
                return isMatch;
              }
          }
        }
        return isMatch;
      }


}