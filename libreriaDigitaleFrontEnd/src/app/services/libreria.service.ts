import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Libro } from '../models/Libro';

@Injectable({
  providedIn: 'root'
})
export class LibreriaService {

  constructor(private http: HttpClient) { }

  getCatalogo(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/libreria/catalogo');
  }

  getLibroPerId(id_libro:number ): Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/libreria/libro/' + id_libro)
  }

  getLibriPerIdUtente(idUtente:number): Observable<any>{
    return this.http.get<any>("http://localhost:8080/api/libreria/libri/utente?idUtente="+idUtente);
  }

  addLibriPerUtente(idUtente:number, idLibro:number){
    return this.http.post("http://localhost:8080/api/libreria/add/libro?idUtente="+idUtente+"&idLibro="+idLibro,null,{ responseType: 'text' });
  }

  eliminaLibriPerUtente(idUtente:number, idLibro:number){
    return this.http.delete("http://localhost:8080/api/libreria/rimuoviLibro?idUtente="+idUtente+"&idLibro="+idLibro,{ responseType: 'text' })
  }

  aggiungiUnaLettura(idLibro:number){
    return this.http.put("http://localhost:8080/api/libreria/lettura/"+idLibro, null, {responseType: 'text'})
  }

  modificaLibroAggiornato(idLibro:number, libroAggiornato:Libro){
    return this.http.put("http://localhost:8080/api/libreria/modifica?idLibro="+idLibro,libroAggiornato, {responseType: 'text'})

  }

}
