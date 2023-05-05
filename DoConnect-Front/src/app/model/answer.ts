import {User} from './user'

export class Answer {
    constructor(
        public id: number,
        public description_answer: string,
        public image_src: string,
        public status: string,
        public datetime: string | null,
        public question_id:number,
        public qapproved_by: number,
        public qcreated_by: number,

    ){}
}