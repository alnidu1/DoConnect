import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../model/user";
import { UserAuthService } from "./user-auth-service";

@Injectable({
    providedIn:"root"
})

export class UserService{

  

    private signupUserUrl = "http://localhost:8080/adduser";
    private authenticateUrl = "http://localhost:8080/authenticate";
    private getAllUsersUrl = "http://localhost:8080/getallusers";


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


    loginUser(loginData:any):Observable<any> {
        return this.http.post(`${this.authenticateUrl}`, loginData,{
            headers: this.requestHeader,
            'responseType': 'text'
        });
    }

    getAllUsers():Observable<User[]>{
        return this.http.get<User[]>(`${this.getAllUsersUrl}`,{
            headers: this.requestHeader,
        });
    }


   


}