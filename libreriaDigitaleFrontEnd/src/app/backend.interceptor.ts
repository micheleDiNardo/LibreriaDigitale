import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable, switchMap, take } from 'rxjs';
import { LoginService } from './services/login.service';

@Injectable()
export class BackendInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        // Escludi un endpoint specifico
      if (req.url.includes('http://localhost:8080/api/login')) {
        return next.handle(req);
      }

      let token = localStorage.getItem('token');

      if (token) {
        const authReq = req.clone({
          setHeaders: {
            Authorization: token,
          },
        });
        return next.handle(authReq);
      } else {
        // Se il token non è disponibile, continua con la richiesta originale
        return next.handle(req);
      }
    
    }
}