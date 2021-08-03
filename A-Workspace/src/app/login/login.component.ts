import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { User } from '../model/user';
import { Service } from '../policy-service/service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  IsError: boolean;
  //private token:string;
  message:string;
  constructor(private service:Service, private router:Router, private appComponent:AppComponent) { }

  ngOnInit() {
  }

  onSubmit(user: User){
    console.log("in");
    this.service.authenticate(user).subscribe(data=>{
      this.router.navigate(["/home"]);
      //this.appComponent.token = data;
      //this.token = data;
      //console.log(this.token);
      this.message="";

    },(error)=>{
      //this.IsError=true;
      this.message="Enter valid Credentials"
      console.log("invalid input");
    });
  }

}
