import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {RegistrationFormComponent } from '../registration-form/registration-form.component';
import { Router } from '@angular/router';
import {MatDialogModule, MatDialog} from '@angular/material/dialog';



@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [MatButtonModule, MatDialogModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent {
 constructor(private route: Router, private dialog: MatDialog){}

 logout() {
  this.route.navigate(["/"]);
  
  }
  
 openPopUp(): void{
  this.dialog.open(RegistrationFormComponent);
 }

//  navigateToRegistration(){

//   this.router.navigate(['registration-form']);
//  }








}
