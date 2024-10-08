import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private userDataSource = new BehaviorSubject
  ({email :'', password :''});
  currentUserData = this.userDataSource.asObservable();


  constructor(private httpClient: HttpClient) {}
  changeData(newUserData: { email: string; password: string; }){
    this.userDataSource.next(newUserData)
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






