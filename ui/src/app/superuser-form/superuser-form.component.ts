import { Component } from '@angular/core';
import { ReactiveFormsModule,FormGroup,FormBuilder} from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-superuser-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './superuser-form.component.html',
  styleUrl: './superuser-form.component.css'
})
export class SuperuserFormComponent {
  SuperuserForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private httpClient:HttpClient){
    this.SuperuserForm=this.formBuilder.group(
      {
        'name': '',
        'email': '',
        'password': '',
      }
    )
  }
  onSubmit(){
    console.log('onsubmit called') ;
    console.log(this.SuperuserForm.value)
    this.httpClient.post('http://localhost:8085/superuser',this.SuperuserForm.value).subscribe((data:any)=>
    console.log('data',data)) ;
    this.SuperuserForm.reset(); 
  };

}
