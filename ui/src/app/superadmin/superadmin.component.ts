import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

const name = new FormControl('');
const password = new FormControl('');

@Component({
  selector: 'app-superadmin',
  standalone: true,
  imports: [NgFor, FormsModule, ReactiveFormsModule ],
  templateUrl: './superadmin.component.html',
  styleUrl: './superadmin.component.css'
})
export class SuperadminComponent implements OnInit {

  admins : any = [];
  data : any = [];
  userForm : FormGroup;
  

  constructor(private httpClient: HttpClient,  private fb: FormBuilder){
    this.userForm = fb.group({
      name, password
    });
  }

  ngOnInit(): void {
    
this.httpClient.get("http://localhost:8085/superadmin").subscribe((data:any) => {

this.admins=data;
console.log(data);
});
}

sendFormDatatoServer() {
  console.log("Request to Send data to Server got hit");
  console.log(this.userForm?.value);
}
      
}
  




