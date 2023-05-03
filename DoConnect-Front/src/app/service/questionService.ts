
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UserAuthService } from "./user-auth-service";
import { Question } from "../model/question";

@Injectable({
    providedIn:"root"
})
export class QuestionService {
    getAllQuestionsUrl:String = "http://localhost:8080/getallquestions";
    getAllPendingUrl:String="http://localhost:8080/getpendingquestions";
    approveQuestionUrl:String="http://localhost:8080/approvequestion";
    denyQuestionUrl:String="http://localhost:8080/denyquestion";

    constructor(private http:HttpClient,
        private userAuthService: UserAuthService){}

        requestHeader = new HttpHeaders({'No-Auth': 'True',
        'Content-Type' : 'application/json',
        'Accept' : '*/*',
        });
    AdminId:string='';
    AId:number=0;
    getAllQuestions() {

        return this.http.get<Question[]>(`${this.getAllQuestionsUrl}`)
    }

    getPendingQuestions() {

        return this.http.get<Question[]>(`${this.getAllPendingUrl}`)
    }

    approveQuestion(question:any){
        this.AdminId = this.userAuthService.getUserId();
        this.AId=parseInt(this.AdminId);
        console.log(`${this.approveQuestionUrl}/${this.AId}`);
        return this.http.put(`${this.approveQuestionUrl}/${this.AId}`,question);
    }

    denyQuestion(question:any){
        return this.http.put(`${this.denyQuestionUrl}`,question);

    }


}
