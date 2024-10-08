import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { CommonModule } from '@angular/common';
import { HttpService } from './http.service';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DashboardComponent } from "./dashboard/dashboard.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterModule,EmpComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'my-angular-app';

  constructor(private httpService: HttpService, private route: Router ) {}
  ngOnInit(): void {
    // this.httpService.empList().subscribe((data) => {
    //   console.log(data);
    // })
  }


  navigate() { this.route.navigate(["/superadmin-forms"]); }

  navigate1() { this.route.navigate(["/superuser-form"]); }

}
