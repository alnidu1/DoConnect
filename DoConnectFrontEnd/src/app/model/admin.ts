export class Admin{
    id:number=0;
    firstname:string="";
    lastname:string = "";
    username:string= "";
    password: string= "";
    email:string="";
    

  
    constructor(fn:string, ln:string , _username:string, _password:string, _email:string){
        
        this.firstname=fn;
        this.lastname=ln;
        this.username=_username;
        this.password=_password;
        this.email=_email;

    }
}