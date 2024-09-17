import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { CommonModule } from '@angular/common';
import { HttpService } from './http.service';




@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterModule,EmpComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'my-angular-app';

  constructor(private httpService: HttpService) {}
  ngOnInit(): void {
    // this.httpService.empList().subscribe((data) => {
    //   console.log(data);
    // })
  }


}
