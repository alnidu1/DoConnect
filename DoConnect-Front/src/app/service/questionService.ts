
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UserAuthService } from "./user-auth-service";
import { Question } from "../model/question";

@Injectable({
    providedIn:"root"
})
export class QuestionService {

    addQuestionUrl:String = "http://localhost:8080/addquestion"
    updateQuestionUrl:String = "http://localhost:8080/updatequestion"
    deleteQuestionUrl:String = "http://localhost:8080/deletequestionbyid"
    getAllQuestionsUrl:String = "http://localhost:8080/getallquestions"
    getAllQuestionsFalseUrl:String = "http://localhost:8080/getallquestionsfalse"
    getAllQuestionsByTopicUrl:String = "http://localhost:8080/getallquestionsbytopic"
    getAllQuestionsByIdUrl:String = "http://localhost:8080/getallquestionsbyid"
    getAllPendingUrl:String="http://localhost:8080/getpendingquestions";
    getAllApprovedQuestionsUrl:String="http://localhost:8080/getapprovedquestions"
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

    addQuestion(question: Question) {
        question.qcreated_id = Number(this.userAuthService.getUserId())
        return this.http.post(`${this.addQuestionUrl}`, question);
    }

    updateQuestion(questionId:number, questionStatus:String) {
        return this.http.put(`${this.updateQuestionUrl}/${questionId}/${questionStatus}`, this.userAuthService.getDecodedAccessToken(this.userAuthService.getToken()));
    }

    deleteQuestion(questionId:number) {
        return this.http.delete(`${this.deleteQuestionUrl}/${questionId}`)
    }

    getAllQuestions() {
        return this.http.get<Question[]>(`${this.getAllQuestionsUrl}`);
    }

    getAllQuestionsFalse() {
        return this.http.get<Question[]>(`${this.getAllQuestionsFalseUrl}`);
    }

    getAllQuestionsByTopic(topic:String) {
        return this.http.get<Question[]>(`${this.getAllQuestionsByTopicUrl}/${topic}`);
    }

    getQuestionById(questionId:number) {
        return this.http.get<Question>(`${this.getQuestionById}/${questionId}`)
    }

    getApprovedQuestions() {
        return this.http.get<Question[]>(`${this.getAllApprovedQuestionsUrl}`)
    }
}
