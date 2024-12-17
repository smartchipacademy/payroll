import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { UrlService } from '../url.service';
import { HttpClient } from '@angular/common/http';
import {MatDialogModule, MatDialog} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { StudentFormComponent } from '../student-form/student-form.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatRippleModule} from '@angular/material/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [NgFor,MatDialogModule, MatButtonModule,CommonModule ,MatTabsModule, MatCardModule,MatTableModule,MatRippleModule,MatPaginator, MatPaginatorModule],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent {
[x: string]: any;
  students: any= [];
  columnsToDisplay = ['score1', 'score2', 'score3', 'score4', 'score5'];

 constructor(private httpclient:HttpClient,private dialog: MatDialog, private route: Router){

  console.log(UrlService.STUDENT_LIST)
  this.httpclient.get(UrlService.STUDENT_LIST).subscribe((data:any)=> {
    this.students=data;
    console.log('api response:', data);
    console .log('Stored data in student var',this.students);
  });

 

 }

 openPopUp(): void{
  console.log("Hitted Here");
  this.dialog.open(StudentFormComponent);
}

logout() {
  this.route.navigate(["/"]);
}


}
