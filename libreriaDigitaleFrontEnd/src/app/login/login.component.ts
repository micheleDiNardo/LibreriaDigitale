import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { response } from 'express';
import { error } from 'console';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

   email: string = '';
   password: string = '';

  constructor(private lservice : LoginService){}

  ngOnInit(): void {
    alert('email: dinardomichele@hotmail.it')
    alert('password: 12345678')
  }

  login(email : string, password: string): void {
    this.lservice.login(email, password).subscribe(
      (token) => {
        localStorage.setItem('token', token);
        console.log('Token salvato:', token);
      },
      (error) => {
        console.error('Errore durante il login:', error);
      }
    );
  }

}
