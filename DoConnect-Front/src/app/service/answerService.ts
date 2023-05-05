import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UserAuthService } from "./user-auth-service";
import { Question } from "../model/question";
import { Answer } from "../model/answer";
import { Observable } from "rxjs";
import { UserService } from "./user.service";
import { User } from "../model/user";

@Injectable({
    providedIn:"root"
})
export class AnswerService {
    addAnswerUrl:String = "http://localhost:8080/addanswer"
    deleteAnswerByIdUrl:String = "http://localhost:8080/deleteanswerbyid"
    getApprovedAnswersUrl:String = "http://localhost:8080/getapprovedanswers"
    getPendingAnswersUrl:String = "http://localhost:8080/getpendinganswers"
    getAllAnswersByQuestionIdUrl:String = "http://localhost:8080/getallanswersbyquestionid"
    approveAnswerUrl:String = "http://localhost:8080/approveanswer"
    denyAnswerUrl:String = "http://localhost:8080/denyanswer"

    constructor(private http:HttpClient, private userAuthService:UserAuthService, private userService:UserService) {}

    addAnswer(answer:Answer):Observable<any> {
        answer.acreated_by = parseInt(this.userAuthService.getUserId())
        return this.http.post(`${this.addAnswerUrl}/${answer.question_id}`, answer)
    }

    deleteAnswer(answerId:number) {
        return this.http.delete(`${this.deleteAnswerByIdUrl}/${answerId}`)
    }

    getApprovedAnswers() {
        return this.http.get<Answer[]>(`${this.getApprovedAnswersUrl}`)
    }

    getPendingAnswers() {
        return this.http.get<Answer[]>(`${this.getPendingAnswersUrl}`)
    }

    getAllAnswersByQuestion(questionId:number) {
        return this.http.get<Answer[]>(`${this.getAllAnswersByQuestionIdUrl}/${questionId}`)
    }

    approveAnswer(answer: Answer) {
        let adminId = parseInt(this.userAuthService.getUserId())
        return this.http.put(`${this.approveAnswerUrl}/${adminId}`, answer)
    }

    denyAnswer(answer: Answer) {
        return this.http.put(`${this.denyAnswerUrl}`, answer)
    }

}