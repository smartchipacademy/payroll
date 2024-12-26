import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-file-upload',
  standalone: true,
  imports:[],
  templateUrl: './file-upload.component.html',
  styleUrl: './file-upload.component.css'
})
export class FileUploadComponent  {

onSubmit() {
throw new Error('Method not implemented.');
}

  selectedFile: File | null = null;

  constructor(private http: HttpClient,private httpclient:HttpClient) {}

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
      console.log('Selected file:', this.selectedFile);
    }
  }

  onUpload(): void {
    if (!this.selectedFile) {
      console.log('No file selected');
      return;
    }

    const formData = new FormData();
    console.log(this.selectedFile);
    formData.append('file', this.selectedFile);

    
    const uploadUrl = 'http://localhost:8085/fileupload/upload';

    this.http.post(uploadUrl, formData).subscribe({
      next: (response) => {
        console.log('File uploaded successfully:', response);
      },
      error: (err) => {
        console.error('Error uploading file:', err);
      }
    });
  }
}





