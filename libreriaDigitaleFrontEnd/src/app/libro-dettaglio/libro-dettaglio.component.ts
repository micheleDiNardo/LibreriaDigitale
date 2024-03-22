import { Component, OnInit } from '@angular/core';
import { LibreriaService } from '../services/libreria.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Libro } from '../models/Libro';

@Component({
  selector: 'app-libro-dettaglio',
  templateUrl: './libro-dettaglio.component.html',
  styleUrl: './libro-dettaglio.component.css'
})
export class LibroDettaglioComponent implements OnInit {

  catalogoData: any;
  id_libro:number = 0 ;

  libroAggiornato:Libro = {
    titolo: "",
    autore: "",
    codiceISBN: "",
    dataAggiuntaLibreria: null,
    dataEliminazione: null,
    numeroLettura: 0,
    trama:"" 
  }

  constructor(private libreriaService: LibreriaService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id_libro = Number(this.route.snapshot.params['id_libro']);
    this.getCatalogoData();
  }

  getCatalogoData(): void {
    this.libreriaService.getLibroPerId(this.id_libro)
    .subscribe(data => {
      this.catalogoData = data;
    });
  }

  submitForm(){
    console.log(this.libroAggiornato)
    console.log(this.id_libro)
    this.libreriaService.modificaLibroAggiornato(this.id_libro,this.libroAggiornato)
    .subscribe(data => {
      console.log(data)
    })
    alert("modifica eseguita con successo")
    this.router.navigate(['/catalogoUtente']);
  }

}
