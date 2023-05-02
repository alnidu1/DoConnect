import { Component } from '@angular/core';
import { OnInit } from '@angular/core';

import { Admin } from '../model/admin';
import { AdminService } from '../service/Admin.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-registration',
  templateUrl: './admin-registration.component.html',
  styleUrls: ['./admin-registration.component.css']
})
export class AdminRegistrationComponent  implements OnInit{

  admins:Admin[];
  model:Admin;

  constructor(private adminService:AdminService, private router:Router){
    this.admins=[];
    this.model= new Admin('','','','','');
}

ngOnInit(): void {
    this.loadAdmin();
}

  addAdmin(loginform:any): void {
    const newAdmin = new Admin(loginform.value.firstname, loginform.value.lastname, loginform.value.username, loginform.value.password, loginform.value.email);
    console.log(newAdmin)
    this.adminService.createAdmin(newAdmin)
      .subscribe(
        response => {
          console.log(response);
          this.loadAdmin();
        },
        error => {
          console.log(error);
        });
        
          this.router.navigate(['/adminlogin']);
        
  }

  loadAdmin(){
    this.adminService.readAll().subscribe(admins=>{
      this.admins=admins;
    })
  }

}
