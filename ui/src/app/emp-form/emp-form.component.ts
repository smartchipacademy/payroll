import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

const first_name = new FormControl('');
const last_name = new FormControl('');
const date_of_joining = new FormControl('');
const email = new FormControl('');
const base_salary = new FormControl('');
const bonus = new FormControl('');


@Component({
  selector: 'app-emp-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './emp-form.component.html',
  styleUrl: './emp-form.component.css'
})
export class EmpFormComponent  {
  empForm!: FormGroup;
  constructor(private fb:FormBuilder,private http:HttpClient){

  }
  onSubmit(){

    this.empForm=this.fb.group({
      first_name,last_name,date_of_joining,email,base_salary,bonus
     });

    console.log('emp Form',this.empForm.value)
    this.http.post('http://localhost:8088/employees',this.empForm.value).subscribe((data:any)=>{
    console.log(data);
    this.empForm.reset();
 });
  }

}
