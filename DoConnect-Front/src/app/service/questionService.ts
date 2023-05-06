import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UserAuthService } from "./user-auth-service";
import { Question } from "../model/question";
import { Observable } from "rxjs";
import { Answer } from "../model/answer";

@Injectable({
    providedIn:"root"
})
export class QuestionService {
    private addQuestionUrl:String = "http://localhost:8080/addquestion"
    private updateQuestionUrl:String = "http://localhost:8080/updatequestion"
    deleteQuestionUrl:String = "http://localhost:8080/deletequestionbyid"
    private getAllQuestionsUrl:String = "http://localhost:8080/getallquestions"
    getAllQuestionsFalseUrl:String = "http://localhost:8080/getallquestionsfalse"
    getAllQuestionsByTopicUrl:String = "http://localhost:8080/getallquestionsbytopic"
    private getQuestionByIdUrl:String = "http://localhost:8080/getquestionbyid"
    private getAllPendingUrl:String="http://localhost:8080/getpendingquestions";
    private getAllApprovedQuestionsUrl:String="http://localhost:8080/getapprovedquestions"
    private approveQuestionUrl:String="http://localhost:8080/approvequestion";
    private denyQuestionUrl:String="http://localhost:8080/denyquestion";
    private baseUrl = 'http://localhost:8080';
    private searchQuestionUrl="http://localhost:8080/searchquestions";

    constructor(private http:HttpClient,
        private userAuthService: UserAuthService){}

        // requestHeader = new HttpHeaders({'No-Auth': 'True',
        // 'Content-Type' : 'application/json',
        // 'Accept' : '*/*',
        // });
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
        return this.http.post(`${this.addQuestionUrl}/${Number(this.userAuthService.getUserId())}`, question);
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
    searchQuestion(s: string): Observable<Question[]> {
        return this.http.get<Question[]>(`${this.baseUrl}/searchquestions/${s}`);
      }


    getAllQuestionsByTopic(topic:String) {
        return this.http.get<Question[]>(`${this.getAllQuestionsByTopicUrl}/${topic}`);
    }

    getQuestionById(questionId:number) {
        return this.http.get<Question>(`${this.getQuestionByIdUrl}/${questionId}`)
    }

    getApprovedQuestions() {
        return this.http.get<Question[]>(`${this.getAllApprovedQuestionsUrl}`)
    }

    addAnswer(questionId: number, answer: Answer): Observable<any> {
        return this.http.post(`${this.baseUrl}/addanswer/${questionId}`, answer);
      }

    getAnswersForQuestion(questionId: number): Observable<Answer[]> {
        return this.http.get<Answer[]>(`${this.baseUrl}/getallanswers/${questionId}`);
    }

    getQuestionUserByID(questionId:number) {
        return this.http.get<Question>(`${this.getQuestionByIdUrl}/${questionId}`)
    }
}
