import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { question } from "../model/question";

@Injectable({
    providedIn:'root'
})

export class QuestionService{
    private url="http://localhost:8080/api/question";

    constructor(private http:HttpClient){

    }

    readAllQuestion():Observable<question []>{
        return this.http.get<question[]>(`${this.url}/${"getallquestions"}`);
    }

    createQuestion(q:question):Observable<question>{
        return this.http.post<question>(`${this.url}/${"addquestion"}`, q);
    }


}