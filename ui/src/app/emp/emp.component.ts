import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UrlService } from '../url.service';
import {  FormGroup } from '@angular/forms';


@Component({
  selector: 'app-emp',
  standalone: true,
  imports: [NgFor],
  templateUrl: './emp.component.html',
  styleUrl: './emp.component.css'
})
export class EmpComponent {
  emp: any = []; 
  


  constructor(private httpclient:HttpClient){
    console.log(UrlService.EMP_LIST)
    this.httpclient.get(UrlService.EMP_LIST).subscribe((data:any)=> {
    this.emp=data;
    console.log('api response: ',data);
    console.log('Stored data in emp var',this.emp);
    });
  }
}



