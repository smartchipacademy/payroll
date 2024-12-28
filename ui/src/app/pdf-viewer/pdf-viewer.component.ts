import { Component , OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pdf-viewer',
  standalone: true,
  imports: [],
  templateUrl: './pdf-viewer.component.html',
  styleUrl: './pdf-viewer.component.css'
})
export class PdfViewerComponent implements OnInit {

    constructor(private urlReader: ActivatedRoute) {}
  
    ngOnInit(): void {}
  
    handleClick(event: any) {
      event.preventDefault();
    }
}
