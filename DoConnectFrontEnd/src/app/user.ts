export class User{

    id:number=0;
    name:string="";
    username:string= "";
    password: string= "";
    email:string="";
    

  
    constructor(fn:string , _username:string, _password:string, _email:string){
        
        this.name=fn;
        this.username=_username;
        this.password=_password;
        this.email=_email;

    }
    
}