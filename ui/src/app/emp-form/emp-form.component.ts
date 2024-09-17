import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

const firstname = new FormControl('');
const lastname = new FormControl('');
const dateofjoining = new FormControl('');
const email = new FormControl('');
const basesalary = new FormControl('');
const bonus = new FormControl('');


@Component({
  selector: 'app-emp-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './emp-form.component.html',
  styleUrl: './emp-form.component.css'
})
export class EmpFormComponent  {
  empForm: FormGroup;
  constructor(private formBulider:FormBuilder,private httpclient:HttpClient){
  this.empForm=this.formBulider.group(
    {
     firstname,
     lastname,
     dateofjoining,
     email,
     basesalary,
     bonus
      
       
    }
  );
  }
  onSubmit(){

    console.log('emptForm',this.empForm.value)
    this.httpclient.post('http://localhost:8088/employees',this.empForm.value).subscribe((data:any)=>{
    console.log(data);
    this.empForm.reset();
 });
  }

}
