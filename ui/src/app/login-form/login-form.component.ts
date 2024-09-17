import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
onSubmit() {
throw new Error('Method not implemented.');
}
  LoginForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private httpClient:HttpClient){
    this.LoginForm=this.formBuilder.group(

      
        {
          'name': '',
          'email': '',
          'password': '',
        }
      )
    }
      }
      onSubmit(){
        console.log('onSubmit called') ;
        console.log(this.LoginForm.value)
        this.httpClient.post('http://localhost:8085/superadmin',this.LoginForm.value).subscribe((data:any)=>
        console.log('data',data)) ;
        this.LoginForm.reset(); 
  };

