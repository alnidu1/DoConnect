import {User} from './user'

export class Answer {
    constructor(
        public id: number,
        public description_answer: String,
        public image_src: String,
        public datetime: String,
        public status: String,
        public qcreated_by: User
    ){}
}