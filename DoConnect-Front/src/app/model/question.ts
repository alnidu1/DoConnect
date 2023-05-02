import { NumberSymbol } from '@angular/common';
import {User} from './user'

export class Question {
    constructor(
        public id: number,
        public description_question: String,
        public image_src: String,
        public datetime: String,
        public status: String,
        public topic: String,
        public title: String,
        public qapproved_by: number,
        public qcreated_id: number
    ){}
}