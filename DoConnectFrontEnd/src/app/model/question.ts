export class question{

    id:number=0;
	title:string="";
    description_question:string="";
    img_src:string="";
	datetime:string="";
	status:string="";
	topic:string="";
    
    constructor(_title:string, dq:string, img:string, dt:string, stat:string, top:string){
        this.title=_title;
        this.description_question=dq;
        this.img_src=img;
        this.datetime=dt;
        this.status=stat;
        this.topic=top;


    }
   
}