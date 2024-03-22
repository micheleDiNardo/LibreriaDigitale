import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UtenteCatalogoComponent } from './utente-catalogo/utente-catalogo.component';
import { LibroDettaglioComponent } from './libro-dettaglio/libro-dettaglio.component';

const routes: Routes = [
{path: 'login', component:LoginComponent},
{path:'', redirectTo:'login', pathMatch: 'full'},
{path: 'catalogoUtente', component:UtenteCatalogoComponent},
{path: 'dettagli/:id_libro', component: LibroDettaglioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
