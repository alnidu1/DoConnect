import {User} from './user'

export class Answer {
    constructor(
        public id: number,
        public description_answer: string,
        public img_src: string,
        public status: string,
        public datetime: string | null,
        public question_id:number,
        public aapproved_by: User,
        public acreated_by: User
    ){}
}
