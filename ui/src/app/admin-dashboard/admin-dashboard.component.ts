import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [RouterOutlet,RouterModule,],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent {
 constructor(private router: Router){}
  

 navigateToRegistration(){

  this.router.navigate(['registration-form']);
 }








}
