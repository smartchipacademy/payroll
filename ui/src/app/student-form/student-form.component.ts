import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './student-form.component.html',
  styleUrl: './student-form.component.css'
})
export class StudentFormComponent {
  studentfrom: FormGroup;
  constructor(private formBuilder: FormBuilder,private httpclient:HttpClient){
    this.studentfrom= this.formBuilder.group(
      {
        'name':'',
        'course':'',
        'phonenumber':'',
        'dateofbirth':'',
        'courseFee':'',
        'address':''
        
      }
    );
  }
  onSubmit(){


    console.log('studentfrom',this.studentfrom.value)
    this.httpclient.post('http://localhost:8088/student',this.studentfrom.value).subscribe((data:any)=>{
    console.log(data);
    this.studentfrom.reset();
  });
}
  

}
