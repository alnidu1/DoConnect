import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { User } from "./user";
@Injectable({
    providedIn:'root'
})

export class UserService
{
    private url="http://localhost:8080/api/user";

    constructor(private http:HttpClient){

    }

    readAllUser():Observable<User[]>{
        return this.http.get<User[]>(`${this.url}`);
    }

    createUser(user:User):Observable<User>{
        return this.http.post<User>(`${this.url}/${"adduser"}`,user);
    }

    updatedUser(user:User):Observable<User>{
        return this.http.put<User>(`${this.url}/${user.id}`,user);
    }

    deleteUser(id:number):Observable<any>{
        return this.http.delete(`${this.url}/${id}`,{responseType:'text'})
    }
}