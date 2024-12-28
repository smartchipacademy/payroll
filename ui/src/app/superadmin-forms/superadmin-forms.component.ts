import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MAT_CHECKBOX_DEFAULT_OPTIONS, MatCheckboxDefaultOptions, MatCheckboxModule} from '@angular/material/checkbox';

@Component({
  selector: 'app-superadmin-forms',
  standalone: true,
  imports: [ReactiveFormsModule, MatSelectModule, MatButtonModule, MatCheckboxModule],
  templateUrl: './superadmin-forms.component.html', 
  styleUrl: './superadmin-forms.component.css',
  providers: [
    {provide: MAT_CHECKBOX_DEFAULT_OPTIONS, useValue: { clickAction: 'noop' } as MatCheckboxDefaultOptions}
  ]
})
export class SuperadminFormsComponent {

  SuperadminForms:FormGroup;
  selectedOption:any = "1";
  
  constructor(private formBuilder:FormBuilder,private httpClient:HttpClient, private route: Router){
    this.SuperadminForms=this.formBuilder.group(
      {
        'userid': 'SCVA000',
        'loginType': '',
        'password': 'SCVA000',
      }
    )
  }

  selectedEvent(event: any) {
    this.selectedOption = Number(event.target.value);
  }
  
  onSubmit(){
    console.log('onsubmit called') ;
    this.SuperadminForms.value.loginType = this.selectedOption;
    console.log(this.SuperadminForms.value)
    console.log("Selected Option : " + this.selectedOption);
    this.httpClient.post('http://localhost:8085/users/login',this.SuperadminForms.value).subscribe((data:any)=>{
      console.log(data);
        // console.log('data',data));
        if(data){
        if(this.selectedOption===1){
          this.route.navigate(["/admin-dashboard"]);
        }
    
        if(this.selectedOption===2){
          this.route.navigate(["/dashboard"]);
        }
        if(this.selectedOption===3){
          this.route.navigate(["/students"]);
        }
        if(this.selectedOption===4){
          const empId = "123";
          this.route.navigate(["/emp/:empId"]);
        }
      }else{
        console.error("INVALID CREDENTIALS!!")
      }
    
        this.SuperadminForms.reset();
     });
    
  }
   
}
