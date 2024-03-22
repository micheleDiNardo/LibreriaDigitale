import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private router: Router) { }

  login(email: string, password: string): Observable<any> {

    const loginRequest = { email: email, password: password };

    return this.http.post<any>('http://localhost:8080/api/login', loginRequest
    );
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('idUtente');
    this.router.navigate(['/login']);

  }
}
