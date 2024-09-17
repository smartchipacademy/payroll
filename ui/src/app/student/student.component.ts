import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { UrlService } from '../url.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [NgFor],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent {
  students: any= [];

 constructor(private httpclient:HttpClient){
  console.log(UrlService.STUDENT_LIST)
  this.httpclient.get(UrlService.STUDENT_LIST).subscribe((data:any)=> {
    this.students=data;
    console.log('api response:', data);
    console .log('Stored data in student var',this.students);
  });
 }



   

}
