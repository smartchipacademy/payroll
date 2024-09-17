import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpClient: HttpClient) {

   }
   saveEmp(data:any): Observable<any>{
    return this.httpClient.post<any>(UrlService.SAVE_EMP, data);
   }
   empList():Observable<any>{
    return this.httpClient.get<any>(UrlService.IP);
   }

  

  saveStudent(data:any):Observable<any>{
    return this.httpClient.get<any>(UrlService.SAVE_STUDENT)

  }

  studentList(data:any):Observable<any>{
    return this.httpClient.get<any>(UrlService.IP)
  }
    
  }






