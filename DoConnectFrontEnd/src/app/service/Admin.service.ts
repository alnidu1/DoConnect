import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

import { Admin } from "../model/admin";

@Injectable({
    providedIn:'root'
})

export class AdminService
{
    private url="http://localhost:8080/api/admin";

    constructor(private http:HttpClient){

    }

    readAll():Observable<Admin[]>{
        return this.http.get<Admin[]>(`${this.url}`);
    }

    createAdmin(admin:Admin):Observable<Admin>{
        return this.http.post<Admin>(`${this.url}/${"register"}`, admin);
    }

    updatedAdmin(admin:Admin):Observable<Admin>{
        return this.http.put<Admin>(`${this.url}/${admin.id}`,admin);
    }

    deleteAdmin(id:number):Observable<any>{
        return this.http.delete(`${this.url}/${id}`,{responseType:'text'})
    }
}