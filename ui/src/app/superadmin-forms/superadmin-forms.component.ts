import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-superadmin-forms',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './superadmin-forms.component.html',
  styleUrl: './superadmin-forms.component.css'
})
export class SuperadminFormsComponent {
  SuperadminForms:FormGroup;
  constructor(private formBuilder:FormBuilder,private httpClient:HttpClient){
    this.SuperadminForms=this.formBuilder.group(
      {
        'name': '',
        'email': '',
        'password': '',
      }
    )
  }
  onSubmit(){
    console.log('onsubmit called') ;
    console.log(this.SuperadminForms.value)
    this.httpClient.post('http://localhost:8085/superadmin',this.SuperadminForms.value).subscribe((data:any)=>
    console.log('data',data)) ;
    this.SuperadminForms.reset(); 
  };
}
