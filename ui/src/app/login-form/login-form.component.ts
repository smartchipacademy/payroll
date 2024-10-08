import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';

import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-LoginForm',
  standalone: true,
  imports: [RouterOutlet,RouterModule,CommonModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent implements OnInit {
  title = 'my-angular-app';
  
  constructor(private route: Router) {}
  
  ngOnInit(): void {
    // this.httpService.empList().subscribe((data) => {
    //   console.log(data);
    // })
  }

  routeTosuperadmin(superadmin: number) {
    console.log("superadmin Id: ",superadmin);
    this.route.navigate(['/dashboard']);
  }

  routeTosuperuser(superuser: number) {
    console.log("superuser Id: ",superuser);
    this.route.navigate(['/dashboard']);
  }




}
