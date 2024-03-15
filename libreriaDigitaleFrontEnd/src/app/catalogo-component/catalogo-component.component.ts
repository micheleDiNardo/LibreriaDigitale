import { Component, OnInit } from '@angular/core';
import { LibreriaService } from '../services/libreria.service';

@Component({
  selector: 'app-catalogo-component',
  templateUrl: './catalogo-component.component.html',
  styleUrl: './catalogo-component.component.css'
})
export class CatalogoComponentComponent implements OnInit {

  catalogoData: any;

  constructor(private libreriaService: LibreriaService) { }

  ngOnInit(): void {
     this.getCatalogoData();
  }

  getCatalogoData(): void {
    this.libreriaService.getCatalogo()
      .subscribe(data => {
        this.catalogoData = data;
      });
  }

}
