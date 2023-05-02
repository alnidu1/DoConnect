import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UserAuthService } from "./user-auth-service";
import { Question } from "../model/question";

@Injectable({
    providedIn:"root"
})
export class QuestionService {
    getAllQuestionsUrl:String = "http://localhost:8080/getallquestions"

    constructor(private http:HttpClient,
        private userAuthService: UserAuthService){}

        requestHeader = new HttpHeaders({'No-Auth': 'True',
        'Content-Type' : 'application/json',
        'Accept' : '*/*',
        });

    getAllQuestions() {

        return this.http.get<Question[]>(`${this.getAllQuestionsUrl}`)
    }
}