import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { RouterOutlet, RouterModule, ActivatedRoute } from '@angular/router';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [RouterOutlet,RouterModule,CommonModule ,MatTabsModule, MatCardModule, NgFor, HttpClientModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  route: any;
  logout() {
    throw new Error('Method not implemented.');
    }

    PDFList : any = [];
    videoList : any = [];

  selectedUser = -1;

  constructor(private activatedRoute: ActivatedRoute,private http: HttpClient) {
    
  }

  ngOnInit(): void {
    console.log(this.activatedRoute.snapshot.params['id']);
    this.selectedUser = this.activatedRoute.snapshot.params["id"];
    this.http.get("http://192.168.0.129:8085/videos").subscribe((data: any) => {
      this.videoList = data;
    });
    this.http.get("http://192.168.0.129:8085/resources").subscribe((data: any) => {
      this.PDFList = data;
    });
  }
  

  routeToVideo(videoId: number) {
    console.log("Video Id : ", videoId);
    this.route.navigate(['/video_player/' + videoId]);
  }

  
routeToPdf(pdfId: number) {
  console.log("file Id: ",pdfId);
  this.route.navigate(['/pdf_viewer/' + pdfId ]);
}



  
}


