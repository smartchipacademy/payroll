import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-superuser',
  standalone: true,
  imports: [NgFor, FormsModule, ReactiveFormsModule],
  templateUrl: './superuser.component.html',
  styleUrl: './superuser.component.css'
})
export class SuperuserComponent implements OnInit {

  users : any = [];
  data : any = [];
  userForm :FormGroup;

  constructor(private httpClient:HttpClient, private fb: FormBuilder){
    this.userForm = fb.group({

    }

    );
  }
  ngOnInit(): void {

        this.httpClient.get("http://localhost:8085/superuser").subscribe((data:any) => {
        this.users=this.data;
        console.log(this.data);
      });
  }

  sendFormDatatoServer() {
    console.log("Request to send data to server got hit");
    console.log(this.userForm?.value);
  }
}
