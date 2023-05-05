import {User} from './user'

export class Answer {
    constructor(
        public id: number,
        public description_answer: String,
        public image_src: String,
        public datetime: string | null,
        public status: string,
        public question_id:number,
        public qcreated_by: number,
        public qapproved_by: number,

    ){}
}