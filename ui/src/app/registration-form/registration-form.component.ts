import { Component, OnInit, } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {MatInputModule} from '@angular/material/input'

@Component({
  selector: 'app-registration-form',
  standalone: true,
  imports: [ReactiveFormsModule,],
  templateUrl: './registration-form.component.html',
  styleUrl: './registration-form.component.css'
})
export class RegistrationFormComponent implements OnInit{

  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {

    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
  }
);
}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

 
  onsubmit() {
    this.submitted = true;

    
    if (this.registerForm.invalid) {
      return;
    }

    
    alert('Registration successful\n\n' + JSON.stringify(this.registerForm.value));
  }
}


