import { Answer } from "./answer";
import { User } from "./user";

export class QuestionUser {
    constructor(
        public id: number,
        public description_question: String,
        public image_src: String,
        public datetime: String,
        public status: String,
        public topic: String,
        public title: String,
        public qapproved_by:User,
        public qcreated_id: User,
        public answers: Answer[]

    ){}
}