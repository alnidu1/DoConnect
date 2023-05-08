import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../model/user";
import { UserAuthService } from "./user-auth-service";

@Injectable({
    providedIn:"root"
})

export class UserService{


    private searchUserUrl="http://localhost:8080/searchquestions";
    private signupUserUrl = "http://localhost:8080/adduser";
    private authenticateUrl = "http://localhost:8080/authenticate";
    private getAllUsersUrl = "http://localhost:8080/getallusers";
    private getUserByIdUrl = "http://localhost:8080/getuserbyid";
    private getUserByUsernmaeUrl = "http://localhost:8080/getuserbyusername"



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
            responseType: 'text'
        });
    }

    getAllUsers():Observable<User[]>{
        return this.http.get<User[]>(`${this.getAllUsersUrl}`,{
            headers: this.requestHeader,
        });
    }

    getUserById(userId: number):Observable<User> {
        return this.http.get<User>(`${this.getUserByIdUrl}/${userId}`)
    }

    getUserByUsername(username:string):Observable<User>{
        return this.http.get<User>(`${this.getUserByUsernmaeUrl}/${username}`)

    }
    checkUsernameExists(username: string): Observable<boolean> {
        return new Observable<true>;
      }





}
