import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {

    const loginRequest = { email: email, password: password };

    return this.http.post('http://localhost:8080/api/login', loginRequest, {responseType: 'text'}
 
    );
  }
}
