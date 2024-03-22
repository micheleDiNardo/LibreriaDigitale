import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

   email: string = '';
   password: string = '';

  constructor(private lservice : LoginService, private router: Router){}

  ngOnInit(): void {}

  login(email : string, password: string): void {
    this.lservice.login(email, password).subscribe(
      (data) => {
        let token = data.token;
        let idUtente = data.idUtente;

        localStorage.setItem('token', token);
        localStorage.setItem('idUtente', idUtente);

        console.log('Token salvato:', token);
        console.log('idUtente : ',idUtente);

        this.router.navigate(['/catalogoUtente']);
      },
      (error) => {
        console.error('Errore durante il login:', error);
      }
    );
  }

}
