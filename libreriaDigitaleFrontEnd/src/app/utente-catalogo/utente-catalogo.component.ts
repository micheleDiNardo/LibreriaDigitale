import { Component, OnInit } from '@angular/core';
import { LibreriaService } from '../services/libreria.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-utente-catalogo',
  templateUrl: './utente-catalogo.component.html',
  styleUrl: './utente-catalogo.component.css'
})
export class UtenteCatalogoComponent implements OnInit {

  catalogoData: any;
  catalogoDataById: any;
  idUtenteNum: number = 0;
  idLibro:number = 0;

  constructor(
    private libreriaService: LibreriaService, 
    private router: Router,
    private route: ActivatedRoute,
    private lService: LoginService
   ) { }

  ngOnInit(): void {
    let idUtente = localStorage.getItem('idUtente');
    //let token = localStorage.getItem('token'); se funziona l'interceptor non mi serve
    
    //let idUtenteNum = 0;
    if (idUtente !== null) {
      this.idUtenteNum = parseInt(idUtente, 10);
      console.log(this.idUtenteNum);
    }

    this.getCatalogoData();
    this.getCatalogoDataPerIdUtente(this.idUtenteNum);
  }

  getCatalogoData(): void {
    this.libreriaService.getCatalogo()
      .subscribe(data => {
        this.catalogoData = data;
        console.log(this.catalogoData)
      });
  }

  getCatalogoDataPerIdUtente(idUtente: number){
    this.libreriaService.getLibriPerIdUtente(idUtente).subscribe(
      (response) => {
        this.catalogoDataById = response;
      }
    )
  }

  aggiungiLibro(idLibro:number){
    this.idLibro = idLibro;
    this.libreriaService.addLibriPerUtente(this.idUtenteNum,this.idLibro).subscribe(
      (response) => {console.log(response)}
    )
    alert("libro aggiunto")
    window.location.reload();
  }

  eliminaLibro(idLibro:number){
    this.idLibro = idLibro;
    this.libreriaService.eliminaLibriPerUtente(this.idUtenteNum,this.idLibro).subscribe(
      (response) => console.log(response)
    )
    alert("libro eliminato")
    window.location.reload();
  }

  leggiLibro(idLibro:number){
    this.idLibro = idLibro;
    this.libreriaService.aggiungiUnaLettura(this.idLibro).subscribe(
      (response) => console.log(response)
    )
    alert("libro letto")
    window.location.reload();
  }

  logout(){
    this.lService.logout();
  }

}
