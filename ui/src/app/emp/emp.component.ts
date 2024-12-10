import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UrlService } from '../url.service';
import {  FormGroup } from '@angular/forms';
import { RouterOutlet, RouterModule, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { Router } from '@angular/router';


@Component({
  selector: 'app-emp',
  standalone: true,
  imports: [RouterOutlet,RouterModule,CommonModule ,MatTabsModule, MatCardModule, NgFor, HttpClientModule],
  templateUrl: './emp.component.html',
  styleUrl: './emp.component.css'
})
export class EmpComponent implements OnInit {
  emp: any = []; 
  empId: string | null = null;
  route: any;
  


  constructor(private httpclient:HttpClient,  route: ActivatedRoute){
    console.log(UrlService.EMP_LIST)
    this.httpclient.get(UrlService.EMP_LIST).subscribe((data:any)=> {
    this.emp=data;
    console.log('api response: ',data);
    console.log('Stored data in emp var',this.emp);
    });
  }
  ngOnInit(): void {
    this.empId = this.route.snapshot.paramMap.get('id');
    console.log('Employee ID:', this.empId);
  }

}



